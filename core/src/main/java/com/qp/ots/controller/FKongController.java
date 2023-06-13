package com.qp.ots.controller;

import com.alibaba.fastjson.JSON;
import com.qp.ots.HttpResult;
import com.qp.ots.utils.DateUtil;
import com.qp.ots.utils.LogUtil;
import com.qp.ots.service.FKongService;
import com.qp.ots.vo.FKongDto;
import com.qp.ots.vo.TaskBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Listen.Li
 * @date 2020.02.19
 */
@RestController
public class FKongController extends AbstractController {

    @Autowired
    private FKongService fkongServiceImpl;

    /**
     * 请求评分
     */
    @RequestMapping(value="/api",method = RequestMethod.POST)
    public HttpResult rmApi(@RequestBody FKongDto req){
        LogUtil.log("api called. productID="+req.getGroupId()+",idCard="+req.getUsrInfo().getIdCard());
        String productID = String.valueOf(System.currentTimeMillis());
        boolean result = fkongServiceImpl.callRmApi(productID,req.getGroupId(),req.getFlag(),JSON.toJSONString(req.getUsrInfo()));
        if(!result){
            return HttpResult.error(300,"try later");
        }
        TaskBean task = new TaskBean();
        task.setProductID(productID);
        task.setStartTime(DateUtil.getStringNowTime());
        task.setScore(0);
        task.setAdvise("无");
        task.setDetails("无");
        task.setEndTime("无");
        task.setStatus("等待中");
        super.cache.set(productID,task);
        return HttpResult.success(productID);
    }
}