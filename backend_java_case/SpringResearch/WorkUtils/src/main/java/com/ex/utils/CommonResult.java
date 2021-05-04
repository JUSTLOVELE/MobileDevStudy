package com.ex.utils;

/**
 * @author yangzl 2020-07-08
 * @version 1.00.00
 * @Description:YmlProjectConfig 读取projectconfig配置信息
 * @Copyright: Copyright (c) 2017 HYKJ All Rights Reserved
 * @Company: 福建互医科技有限公司
 * @history:
 */
public class CommonResult<T> {

    private Integer code;

    private String message;

    private Boolean success;

    private T datas;

    private Integer total;

    public CommonResult(){

    }

    public CommonResult(Integer code, String message, Boolean success, T data, Integer total) {
        this.code = code;
        this.message = message;
        this.success = success;
        this.datas = data;
        this.total = total;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getDatas() {
        return datas;
    }

    public void setDatas(T datas) {
        this.datas = datas;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
