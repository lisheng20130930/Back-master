package com.qp.ots.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qp.ots.service.FKongService;
import com.qp.ots.utils.HttpClient;
import com.qp.ots.utils.LogUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Listen.Li
 */
@Service
public class FKongServiceImpl implements FKongService {

    @Value("${com.usr.rmUrl}")
    private String rmUrl;

    @Override
    public boolean callRmApi(String ID, String groupId, int flag, String usrInfo){
        String reqStr = "{\"ID\":\""+ID+"\"";
        reqStr += ",\"groupId\":\""+groupId+"\"";
        reqStr += ",\"flag\":"+flag;
        reqStr += ",\"usrInfo\":"+usrInfo;
        reqStr += "}";
        System.out.println("SEND===>"+reqStr);
        boolean bResult = false;
        try {
            String str = HttpClient.sendPost(rmUrl, reqStr, "application/json");
            LogUtil.log("callRmApi result="+str);
            if(str!=null&&str.length()>0) {
                JSONObject result = JSON.parseObject(str);
                if (result.containsKey("code") && 200==result.getIntValue("code")) {
                    bResult = true;
                }
            }
        }catch (Exception e){
            LogUtil.log(e.getMessage());
        }
        return bResult;
    }
}
