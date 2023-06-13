package com.qp.ots.prs.prs;

import com.alibaba.fastjson.JSON;
import com.qp.ots.prs.BaseParser;
import com.qp.ots.prs.EScheme;
import com.qp.ots.prs.entity.DTD;
import com.qp.ots.utils.Logger;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class NmParser extends BaseParser {
    public NmParser(Integer category) {
        super(1, category);
    }

    @Override
    public boolean parse(List<List<String>> ll, DTD dtd) {
        List<EScheme> schemes = EScheme.schemes(type, category);
        List<String> hl = ll.get(0);
        if(hl==null){
            Logger.log("[NmParser] getHeaderList error");
            return false;
        }
        if(!compareHeaders(hl, schemes)){
            Logger.log("[NmParser] compareHeaders error");
            return false;
        }
        List<Map<String, Object>> list = new LinkedList<>();
        for(int i=1;i<ll.size();i++){
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

    public static void main(String[] args) throws Exception {
        DTD dtd = DTD.fromFile(1, 10, "G:\\Sns-SVN\\周报表数据\\第1周\\新材BU周报-产销情况周报.xlsx");
        //DTD dtd = DTD.fromFile(1, 11, "G:\\Sns-SVN\\周报表数据\\新材BU周报-原材料库存周报.xlsx");
        if(dtd!=null){
            System.out.println(JSON.toJSONString(dtd));
        }
    }
}
