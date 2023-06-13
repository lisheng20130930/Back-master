package com.qp.ots.controller;

import com.alibaba.fastjson.JSONObject;
import com.qp.ots.HttpResult;
import com.qp.ots.utils.LogUtil;
import com.qp.ots.service.ImportService;
import com.qp.ots.vo.IdCardsDto;
import com.qp.ots.vo.UsrBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Listen.Li
 * @date 2020.02.19
 */
@RestController
@RequestMapping("/import")
public class ImportController {

    @Autowired
    private ImportService importService;

    /**
     * 从数据库加载用户数据
     */
    @RequestMapping(value="/getUsr",method = RequestMethod.POST)
    public HttpResult getUsr(@RequestBody JSONObject req){
        LogUtil.log("getUsr called. content="+req.toJSONString());
        /**
         * 从数据库获取
         * UsrBean usr = importService.loadUsrBeanFormDB(req.getString("idCard"));
         */

        /**
         * 从涛涛提供的接口获取
         */
        UsrBean usr = importService.loadUsrBeanFromProxy(req.getString("idCard"));
        if(null==usr){
            return HttpResult.error(0,"error");
        }
        return HttpResult.success(usr);
    }

    /**
     * 从数据库加载IDCARD列表
     */
    @RequestMapping(value="/idCards",method = RequestMethod.POST)
    public HttpResult getIdCards(@RequestBody JSONObject req){
        LogUtil.log("getIdCards called. content="+req.toJSONString());

        /**
         * 从数据库获取
         * IdCardsDto idCards = importService.loadIdCardsFormDB();
         */

        /**
         * 从涛涛提供的接口获取
         */
        IdCardsDto idCards = importService.loadIdCardsFormProxy();
        return HttpResult.success(idCards);
    }
}
