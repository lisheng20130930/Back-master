package com.qp.ots.controller;

import com.qp.ots.HttpResult;
import com.qp.ots.utils.LogUtil;
import com.qp.ots.vo.QueryDto;
import com.qp.ots.vo.TaskBean;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Listen.Li
 * @date 2020.02.19
 */
@RestController
public class QueryController extends AbstractController {
    /**
     * 查询结果
     */
    @RequestMapping(value="/query",method = RequestMethod.POST)
    public HttpResult query(@RequestBody QueryDto req){
        LogUtil.log("query called. productID="+req.getProductID());
        if(req.getProductID().equals("*")){
            return HttpResult.success(super.cache.getAll());
        }
        TaskBean task = (TaskBean) super.cache.get(req.getProductID());
        if (null == task) {
           return HttpResult.error(404, "Not Found");
        }
        List<TaskBean> list = new LinkedList<>();
        list.add(task);
        return HttpResult.success(list);
    }
}