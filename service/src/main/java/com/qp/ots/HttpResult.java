package com.qp.ots;

/**
 * HTTP请求返回的最外层对象
 *
 * @author Listen.Li
 * @date 2018.10.01
 */
public class HttpResult<T> {
    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体的内容. */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public static HttpResult success(Object object) {
        HttpResult httpResultDto = new HttpResult();
        httpResultDto.setCode(200);
        httpResultDto.setMsg("success");
        httpResultDto.setData(object);
        return httpResultDto;
    }

    public static HttpResult success() {
        return success(null);
    }

    public static HttpResult error(Integer code, String msg) {
        HttpResult httpResultDto = new HttpResult();
        httpResultDto.setCode(code);
        httpResultDto.setMsg(msg);
        return httpResultDto;
    }
}
