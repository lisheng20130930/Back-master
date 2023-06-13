package com.qp.ots.prs;

import com.qp.ots.prs.entity.DTD;
import com.qp.ots.prs.prs.BUAParser;
import com.qp.ots.prs.prs.BatteryParser;
import com.qp.ots.prs.prs.CmParser;
import com.qp.ots.prs.prs.NmParser;
import com.qp.ots.utils.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.List;

public class Dao {
    public synchronized static List<XSSFWorkbook> prepare(List<String> excelList){
        try{
            List<XSSFWorkbook> r = new LinkedList<>();
            for(String s : excelList){
                r.add(new XSSFWorkbook(new FileInputStream(new File(s))));
            }
            return r;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void closeAll(List<XSSFWorkbook> list){
        for(XSSFWorkbook workbook : list){
            try{
                workbook.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private static BaseParser getParser(Integer type, Integer category){
        if(type!=null){
            if(type==4){
                return new BatteryParser(category);
            }
            if(type==1){
                return new NmParser(category);
            }
            if(type==2){
                return new BUAParser(category);
            }
            if(type==3){
                return new CmParser(category);
            }
        }
        return null;
    }

    public static DTD parse(int type, int category, XSSFSheet sheet) {
        BaseParser parser = Dao.getParser(type,category);
        if(parser==null){
            Logger.log("get parser error");
            return null;
        }
        DTD dtd = new DTD();
        parser.setParams(dtd,sheet);
        boolean r = false;
        try{
            Integer ret = parser.call();
            if(ret==0){
                r = true;
            }
        }catch (Exception e){
            Logger.log(e.getMessage());
        }
        if(r){
            return dtd;
        }
        return null;
    }

    public static List<List<String>> rotate90(List<List<String>> ll){
        List<List<String>> r = new LinkedList<>();
        int size = 0;
        for(List<String> l : ll){
            if(size==0||size<l.size()){
                size = l.size();
            }
        }
        for(int i=0;i<size;i++){
            List<String> n = new LinkedList<>();
            for(List<String> l : ll){
                if(i<l.size()){
                    n.add(l.get(i));
                }
            }
            r.add(n);
        }
        return r;
    }
    /**
    public static void main(String[] args) throws Exception{
        List<Report> list = Service.getInstance().getReportList();
        for(Report r : list){
            String s = Base64Utils.encode(r.getDtd());
            System.out.println(r.getId()+":"+s);
            Service.getInstance().updateReport(r.getId(),s);
        }
    }*/
}
