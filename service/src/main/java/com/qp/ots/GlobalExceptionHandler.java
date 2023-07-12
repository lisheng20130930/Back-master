package com.qp.ots;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 自定义业务异常处理
     */
    @ExceptionHandler(RRException.class)
    public HttpResult handleRRException(RRException e) {
        return HttpResult.error(e.getCode(), e.getMsg());
    }

    /**
     * 添加全局异常处理流程，根据需要设置需要处理的异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object MethodArgumentNotValidHandler(HttpServletRequest request, Exception exception) throws Exception {
        return HttpResult.error(500, "");
    }
}