package com.qp.ots.controller;

import com.alibaba.fastjson.JSON;
import com.qp.ots.HttpResult;
import com.qp.ots.ReqBody;
import com.qp.ots.entity.NameList;
import com.qp.ots.utils.LogUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Listen.Li
 */
@RestController
public class BasicInfoController extends AbstractController {
    @RequestMapping(value="/basicInfo",method = RequestMethod.POST)
    public HttpResult basicInfo(@RequestBody ReqBody requestBody){
        LogUtil.log("basicInfo called. content="+ JSON.toJSONString(requestBody));
        if(!preHandleRequest(requestBody)){
            return HttpResult.error(403,"");
        }
        NameList nameEntry = new NameList();
        List<String > names = new ArrayList<>();
        HashMap<String,Object> payload = requestBody.getPayload();
        Integer objPage = (Integer)payload.get("page");
        int page = 0;
        if(null!=objPage) {
            page = objPage.intValue();
        }
        if(page<3){
            for(int i=0;i<20;i++) {
                names.add("哈哈哈哈_"+page+"_"+i);
            }
        }
        nameEntry.setNames(names);
        return HttpResult.success(nameEntry);
    }
}
