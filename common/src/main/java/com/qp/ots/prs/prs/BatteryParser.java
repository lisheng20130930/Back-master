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

public class BatteryParser extends BaseParser {
    public BatteryParser(Integer category) {
        super(4, category);
    }

    @Override
    public boolean parse(List<List<String>> ll, DTD dtd) {
        List<EScheme> schemes = EScheme.schemes(type, category);
        List<String> hl;
        int i;
        if(category==40){//电池BU周报-产销存周报
            hl = getHeaderList(ll);
            i = 2;
        }else{
            hl = ll.get(0);
            i = 1;
        }
        if(hl==null){
            Logger.log("[BatteryParser] getHeaderList error");
            return false;
        }
        if(!compareHeaders(hl, schemes)){
            Logger.log("[BatteryParser] compareHeaders error");
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
                        if(i>0){
                            a = p.get(i-1);
                        }
                    }
                    r.add(a+b);
                }
                return r;
            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        DTD dtd = DTD.fromFile(4, 40, "G:\\Sns-SVN\\周报表数据\\第1周\\电池BU周报-产销存周报.xlsx");
        //DTD dtd = DTD.fromFile(4, 41, "G:\\Sns-SVN\\周报表数据\\第1周\\电池BU周报-原材料采购及库存周报.xlsx");
        //DTD dtd = DTD.fromFile(4, 42, "G:\\Sns-SVN\\周报表数据\\电池BU周报-效率周报.xlsx");
        if(dtd!=null){
            System.out.println(JSON.toJSONString(dtd));
        }
        /*
        DTD dtd = DTD.fromFile(4, 40, "G:\\Sns-SVN\\周报表数据\\第2周\\电池BU周报-产销存周报.xlsx");
        if(dtd!=null){
            String s = Base64Utils.encode(JSON.toJSONString(dtd));
            System.out.println(s);
            System.out.println(Service.getInstance().updateReport(13, s));
        }
         */
    }
}
