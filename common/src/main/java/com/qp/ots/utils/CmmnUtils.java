package com.qp.ots.utils;

import org.apache.tomcat.util.http.fileupload.FileUtils;

import java.io.File;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class CmmnUtils {
    public static void sleep(long millis){
        try{
            Thread.currentThread().sleep(millis);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static long random(int range){
        if(range==0){
            return range;
        }
        return System.currentTimeMillis()%range;
    }

    public static boolean isEmpty(String str){
        return str==null || str.length()==0;
    }

    public static String list2Str(List<String> list){
        if(list == null || list.size() == 0){
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for(String s : list){
            builder.append(",").append(s);
        }
        return builder.toString().substring(1);
    }

    public static List<String> str2List(String str){
        return CmmnUtils.str2List(str,",");
    }
    
    public static List<String> str2List(String str, String regex){
        List<String> list = new LinkedList<>();
        if(CmmnUtils.isEmpty(str)){
            return list;
        }
        String[] ids = str.split(regex);
        for (String id : ids) {
            id = id.trim();
            if (id == null || id.length()==0) {
                continue;
            }
            if(!list.contains(id)) {
                list.add(id);
            }
        }
        return list;
    }

    public static String expressConvert(String name, String express){
        String s = express.replace("%", "/100.0");
        return name+s;
    }

    public static String prettyDouble(Double v, boolean omit){
        try{
            DecimalFormat decimalFormat = new DecimalFormat("###################.00");
            String s = decimalFormat.format(v);
            if(omit&&s.endsWith(".00")){
                s = s.substring(0,s.length()-3);
                if(s.equals("")){
                    return "0";
                }
            }
            return s;
        }catch (Exception e){
        }
        return null;
    }

    public static String prettyDouble(Double v){
        return prettyDouble(v,true);
    }

    public static Integer asInteger(String s){
        if(CmmnUtils.isEmpty(s)){
            return null;
        }
        try{
            return Integer.parseInt(s);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static Double asDouble(String s){
        if(CmmnUtils.isEmpty(s)){
            return null;
        }
        try{
            return Double.parseDouble(s);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static Float asFloat(String s){
        if(CmmnUtils.isEmpty(s)){
            return null;
        }
        try{
            return Float.parseFloat(s);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static Long asLong(String s) {
        if(CmmnUtils.isEmpty(s)){
            return null;
        }
        try{
            return Long.parseLong(s);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static Date asDate(String strDate){
        try {
            return new Date(Long.parseLong(strDate));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static boolean isEmpty(List list){
        if(list==null||list.size()==0){
            return true;
        }
        return false;
    }

    public static boolean equals(String s, List<String> keywords){
        s = s.toLowerCase();
        int p = 0;
        for(String keyword : keywords){
            keyword = keyword.toLowerCase();
            p = s.indexOf(keyword,p);
            if(p==(-1)){
                return false;
            }
        }
        return true;
    }

    public static String formatTrace(String str) {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTime.format(formatter)+"  "+str+"\r\n";
    }
}
