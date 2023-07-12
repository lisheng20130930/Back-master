package com.qp.fliter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.qp.ots.utils.Logger;
import org.springframework.stereotype.Component;

@Component
public class ErrorFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "error";
    }
    @Override
    public int filterOrder() {
        return 10;
    }
    @Override
    public boolean shouldFilter() {
        return true;
    }
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        Throwable throwable = ctx.getThrowable();
        Logger.log("Filter Erroe : {}");
        return null;
    }
}
