package com.qp.ots.controller;

import com.alibaba.fastjson.JSONObject;
import com.qp.ots.HttpResult;
import com.qp.ots.utils.DateUtil;
import com.qp.ots.utils.LogUtil;
import com.qp.ots.vo.TaskBean;
import org.springframework.web.bind.annotation.*;

/**
 * @author Listen.Li
 * @date 2020.02.19
 */
@RestController
public class ReportController extends AbstractController {
    /**
     * 评分通知回调
     */
    @RequestMapping(value="/report",method = RequestMethod.POST)
    public HttpResult report(@RequestBody JSONObject req){
        LogUtil.log("report called. content="+req.toJSONString());
        TaskBean task = (TaskBean) super.cache.get(req.getString("ID"));
        if (null != task) {
            task.setEndTime(DateUtil.getStringNowTime());
            task.setStatus(req.getIntValue("code") == 200 ? "成功" : "失败");
            task.setScore(req.getIntValue("score"));
            if(req.containsKey("advise")) {
                task.setAdvise(req.getString("advise"));
            }
            if(req.containsKey("details")) {
                task.setDetails(req.getString("details"));
            }
        }
        return HttpResult.success();
    }
}
