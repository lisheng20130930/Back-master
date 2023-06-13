package com.qp.ots.prs.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qp.ots.prs.Dao;
import com.qp.ots.prs.EScheme;
import com.qp.ots.utils.CmmnUtils;
import com.qp.ots.utils.Logger;
import lombok.Data;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.util.*;

@Data
public class DTD {
    List<Map<String, Object>> list;

    public static DTD valueOf(String str){
        try{
            DTD dtd = new DTD();
            JSONObject root = JSON.parseObject(str);
            String s = root.getString("list");
            if(!CmmnUtils.isEmpty(s)){
                List<String> list = JSON.parseArray(s, String.class);
                List<Map<String, Object>> r = new LinkedList<>();
                for(String p : list){
                    r.add(JSON.parseObject(p, Map.class));
                }
                dtd.setList(r);
            }
            return dtd;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static DTD fromInputStream(Integer type, Integer category, InputStream inputStream) throws Exception {
        System.out.println("[fromInputStream] enter. type="+type+",category="+category);
        XSSFWorkbook wb = new XSSFWorkbook(inputStream);
        try {
            XSSFFormulaEvaluator.evaluateAllFormulaCells(wb);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        XSSFSheet sheet = wb.getSheetAt(0);
        if(sheet==null){
            System.out.println("[fromInputStream] sheet error..");
            return null;
        }
        wb.close();
        DTD dtd = Dao.parse(type,category,sheet);
        if(dtd==null){
            System.out.println("[fromInputStream] parse error..");
            return null;
        }
        return dtd;
    }

    public static DTD fromFile(int type, int category, String filename){
        Logger.log("[fromFile] enter. type="+type+",category="+category+",filename="+filename);
        List<XSSFWorkbook> wbList = Dao.prepare(Arrays.asList(
                filename
        ));
        if(wbList==null){
            Logger.log("[fromFile] prepare error..");
            return null;
        }
        try {
            XSSFFormulaEvaluator.evaluateAllFormulaCells(wbList.get(0));
        }catch (Exception e){
            Logger.log(e.getMessage());
        }
        XSSFSheet sheet = wbList.get(0).getSheetAt(0);
        if(sheet==null){
            Logger.log("[fromFile] sheet error..");
            return null;
        }
        Dao.closeAll(wbList);
        DTD dtd = Dao.parse(type,category,sheet);
        if(dtd==null){
            Logger.log("[fromFile] parse error..");
            return null;
        }
        return dtd;
    }

    public static String encode(String str, String s, Integer type, Integer category) throws Exception {
        DTD dtd = DTD.valueOf(str);
        if(dtd==null){
            throw new Exception("parse error");
        }
        List<List<String>> ll = new LinkedList<>();
        JSONArray array = JSON.parseArray(s);
        for(int i=0;i<array.size();i++){
            ll.add(JSON.parseArray(array.getString(i), String.class));
        }
        if(ll.size()!=dtd.getList().size()){
            throw new Exception("");
        }
        if(ll.size()>0){
            if(ll.get(0).size()!=ll.get(0).size()){
                throw new Exception("data error");
            }
        }
        List<EScheme> schemes = EScheme.schemes(type,category);
        List<Map<String, Object>> list = new LinkedList<>();
        for(int i=0;i<ll.size();i++){
            Map<String, Object> m = dtd.getList().get(i);
            List<String> l = ll.get(i);
            Map<String, Object> n = new HashMap<>();
            int j = 0;
            for (EScheme scheme : schemes) {
                Object o = m.get(scheme.name());
                String v = l.get(j);
                if(scheme.asString(o).equals(v)){
                    n.put(scheme.name(),o);
                }else{
                    n.put(scheme.name(),
                            EScheme.parseValue(scheme.name(),v)
                    );
                }
                j++;
            }
            list.add(n);
        }
        dtd.setList(list);
        return JSON.toJSONString(dtd);
    }

    public static String decode(String s, Integer type, Integer category) throws Exception {
        DTD dtd = DTD.valueOf(s);
        if(dtd==null){
            throw new Exception("parse error");
        }
        List<List<String>> r = new LinkedList<>();
        for(Map<String, Object> m : dtd.getList()){
            List<EScheme> schemes = EScheme.schemes(type,category);
            List<String> l = new LinkedList<>();
            for (EScheme scheme : schemes) {
                String v = scheme.asString(
                        m.get(scheme.name())
                );
                l.add(v);
            }
            r.add(l);
        }
        return JSON.toJSONString(r);
    }
}
