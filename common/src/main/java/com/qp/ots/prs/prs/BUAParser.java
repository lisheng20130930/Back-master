package com.qp.ots.prs.prs;

import com.alibaba.fastjson.JSON;
import com.qp.ots.prs.BaseParser;
import com.qp.ots.prs.EScheme;
import com.qp.ots.prs.entity.DTD;
import com.qp.ots.utils.CmmnUtils;
import com.qp.ots.utils.Logger;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BUAParser extends BaseParser {
    public BUAParser(Integer category) {
        super(2, category);
    }

    @Override
    public boolean parse(List<List<String>> ll, DTD dtd) {
        List<EScheme> schemes = EScheme.schemes(type, category);
        List<String> hl;
        int i;
        if(category==22){//应用BU周报-原材料库存情况周报
            hl = getHeaderList(ll);
            i = 2;
        }else{
            hl = ll.get(0);
            i = 1;
        }
        if(hl==null){
            Logger.log("[BUAParser] getHeaderList error");
            return false;
        }
        if(!compareHeaders(hl, schemes)){
            Logger.log("[BUAParser] compareHeaders error");
            return false;
        }
        List<Map<String, Object>> list = new LinkedList<>();
        for(;i<ll.size();i++){
            List<String> l = ll.get(i);
            if(l.size()>0){
                Map<String, Object> m = new LinkedHashMap<>();
                for (EScheme scheme : schemes) {
                    int t = locate(hl, scheme);
                    if (t != (-1)) {
                        m.put(scheme.name(), parseValue(l.get(t), scheme));
                    }
                }
                list.add(m);
            }
        }
        dtd.setList(list);
        return true;
    }

    private List<String> getHeaderList(List<List<String>> ll) {
        if(ll.size()>=2){
            List<String> p = ll.get(0);
            List<String> q = ll.get(1);
            if(p!=null&&q!=null){
                List<String> r = new LinkedList<>();
                int size = Math.max(p.size(),q.size());
                for(int i=0;i<size;i++){
                    String a = "";
                    if(i<p.size()){
                        a = p.get(i);
                    }
                    String b = "";
                    if(i<q.size()){
                        b = q.get(i);
                    }
                    if(CmmnUtils.isEmpty(a)){
                        for(int t=i;t>0;t--){
                            if(t<=p.size()){
                                a = p.get(t-1);
                                if(!CmmnUtils.isEmpty(a)){
                                    break;
                                }
                            }
                        }
                    }
                    r.add(a+b);
                }
                return r;
            }
        }
        return null;
    }

    //20需更新第1周

    public static void main(String[] args){
        //DTD dtd = DTD.fromFile(2, 20, "G:\\Sns-SVN\\周报表数据\\第1周\\应用BU周报-开发量及并网量周报.xlsx");
        DTD dtd = DTD.fromFile(2, 21, "G:\\Sns-SVN\\周报表数据\\第1周\\应用BU周报-主要原材料采购情况周报.xlsx");
        //DTD dtd = DTD.fromFile(2, 22, "G:\\Sns-SVN\\周报表数据\\第1周\\应用BU周报-原材料库存情况周报.xlsx");
        //DTD dtd = DTD.fromFile(2, 23, "G:\\Sns-SVN\\周报表数据\\应用BU周报-异常农户卡处理进度周报.xlsx");
        if(dtd!=null){
            System.out.println(JSON.toJSONString(dtd));
        }
    }
}
