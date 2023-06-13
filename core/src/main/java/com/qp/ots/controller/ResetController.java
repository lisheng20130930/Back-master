package com.qp.ots.controller;


import com.qp.ots.HttpResult;
import com.qp.ots.vo.ResetDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Listen.Li
 * @date 2020.02.19
 */
@RestController
public class ResetController extends AbstractController {
    /**
     * 清理
     */
    @RequestMapping(value="/clear",method = RequestMethod.POST)
    public HttpResult clear(@RequestBody ResetDto req){
        super.cache.clean();
        return HttpResult.success();
    }
}
