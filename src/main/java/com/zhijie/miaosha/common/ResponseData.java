package com.zhijie.miaosha.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * @Description:ajax请求结果集封装
 * @Author:童志杰
 * @Since:2018年1月10日
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseData<T> implements Serializable {

    /**
     * 设置成功和失败常量
     */

    public final static int SUCCESS = 1;
    public final static int ERROR = 0;

    private int status;
    private String msg;
    private T data;
    @JsonIgnore
    private boolean success;

    private ResponseData(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ResponseData<T> success() {
        return new ResponseData<T>(ResponseData.SUCCESS, null, null);
    }

    public static <T> ResponseData<T> successByMsg(String msg) {
        return new ResponseData<T>(ResponseData.SUCCESS, msg, null);
    }

    public static <T> ResponseData<T> successByData(String msg, T data) {
        return new ResponseData<T>(ResponseData.SUCCESS, msg, data);
    }

    public static <T> ResponseData<T> successByData(T data) {
        return new ResponseData<T>(ResponseData.SUCCESS, null, data);
    }


    public static <T> ResponseData<T> error() {
        return new ResponseData<T>(ResponseData.ERROR, null, null);
    }

    public static <T> ResponseData<T> errorByMsg(String msg) {
        return new ResponseData<T>(ResponseData.ERROR, msg, null);
    }

    public static <T> ResponseData<T> errorByData(String msg, T data) {
        return new ResponseData<T>(ResponseData.ERROR, msg, data);
    }

    public static <T> ResponseData<T> errorByData(T data) {
        return new ResponseData<T>(ResponseData.ERROR, null, data);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public Boolean isSuccess() {
        if (status == SUCCESS) {
            return true;
        } else {
            return false;
        }
    }

}
