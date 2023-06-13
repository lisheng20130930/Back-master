package com.qp.ots.prs;

import com.qp.ots.prs.entity.DTD;
import com.qp.ots.utils.CmmnUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

public abstract class BaseParser implements Callable<Integer> {
    protected Integer category;
    protected Integer type;
    private XSSFSheet _sheet;
    private DTD _dtd;

    /************************************************
     * //新材BU周报
     * 10-产销情况周报
     * 11-原材料库存周报
     *
     * //应用BU周报
     * 20-开发量及并网量周报
     * 21-主要原材料采购情况周报
     * 22-原材料库存情况周报
     * 23-异常农户卡处理进度周报
     *
     * //组建BU周报
     * 30-产销存周报
     * 31-原材料采购及库存周报
     * 32-效率周报
     *
     * //电池BU周报
     * 40-产销存周报
     * 41-原材料采购及库存周报
     * 42-效率周报
     ************************************************/

    public BaseParser(Integer type, Integer category) {
        this.category = category;
        this.type = type;
    }

    protected List<List<String>> read(XSSFSheet sheet) {
        try {
            if (sheet.getLastRowNum() > 0) {
                List<List<String>> r = new LinkedList<>();
                for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
                    XSSFRow row = sheet.getRow(j);
                    if (row != null) {
                        List<String> l = new LinkedList<>();
                        for (int k = 0; k < row.getLastCellNum(); k++) {
                            XSSFCell cell = row.getCell(k);
                            if (cell != null) {
                                if (cell.getCellType() == CellType.FORMULA) {
                                    l.add(cell.getRawValue());
                                } else {
                                    l.add(getValue(cell));
                                }
                            } else {
                                l.add("");
                            }
                        }
                        boolean isEmpty = true;
                        for (String s : l) {
                            if (!s.equals("")) {
                                isEmpty = false;
                                break;
                            }
                        }
                        if (!isEmpty) {
                            r.add(l);
                        }
                    }
                }
                return r;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected String getValue(XSSFCell cell){
        String value;
        CellType type = (cell!=null)?cell.getCellType():CellType.BLANK;
        switch (type) {
            case STRING:
                value = cell.getStringCellValue();
                break;
            case BOOLEAN:
                value = String.valueOf(cell.getBooleanCellValue());
                break;
            case NUMERIC:
                try {
                    value = String.valueOf(cell.getNumericCellValue());
                }catch (Exception e){
                    value = "";
                }
                break;
            case FORMULA:
                value = cell.getCellFormula();
                break;
            default:
                value = "";
                break;
        }
        return trim(value);
    }

    protected boolean compareHeaders(List<String> list, List<EScheme> values, List<String> errorList) {
        for (EScheme scheme : values) {
            if (locate(list, scheme) == (-1)) {
                if(errorList!=null){
                    errorList.add(scheme.value());
                }
                return false;
            }
        }
        return true;
    }


    protected boolean compareHeaders(List<String> list, List<EScheme> values) {
        return compareHeaders(list,values,null);
    }

    protected int locate(List<String> list, EScheme scheme){
        //完全匹配
        for(int i=0;i<list.size();i++){
            String s = list.get(i);
            if(s.equals(scheme.value())){
                return i;
            }
        }
        //模糊匹配
        for(int i=0;i<list.size();i++){
            String s = list.get(i);
            if(equals(s,scheme)){
                return i;
            }
        }
        return (-1);
    }

    protected boolean equals(String s, EScheme scheme){
        List<String> keywords = Arrays.asList(scheme.value().split("[ *% :.-]"));
        return CmmnUtils.equals(s,keywords);
    }

    public static Object parseValue(String value, EScheme scheme){
        return scheme.parseValue(value);
    }

    protected String trim(String s){
        return s;
        //return s.trim();
    }

    public void setParams(DTD dtd, XSSFSheet sheet){
        this._sheet = sheet;
        this._dtd = dtd;
    }

    @Override
    public Integer call() throws Exception {
        boolean r = false;
        try{
            r = parse(_sheet,_dtd);
        }catch (Exception e){
            e.printStackTrace();
        }
        _sheet = null;
        _dtd = null;
        return r?0:(-1);
    }

    public boolean parse(XSSFSheet sheet, DTD dtd){
        List<List<String>> ll = read(sheet);
        if(ll==null){
            return false;
        }
        return parse(ll,dtd);
    }

    public abstract boolean parse(List<List<String>> ll, DTD dtd);
}
