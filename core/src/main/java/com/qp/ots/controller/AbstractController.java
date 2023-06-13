package com.qp.ots.controller;

import com.qp.ots.ReqBody;
import com.qp.ots.utils.MapCache;

/**
 * Controller基类
 *
 * @author Listen.Li
 * @date 2020.02.20
 */
public class AbstractController {
    protected MapCache cache = MapCache.getInstance();

    protected boolean preHandleRequest(ReqBody req){
        return true;
    }
}
