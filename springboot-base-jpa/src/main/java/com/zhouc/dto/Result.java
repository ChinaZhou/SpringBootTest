package com.zhouc.dto;

/**
 * Created by Administrator on 2017/9/8.
 */
public class Result<T> {

    private String code;
    private String mes;
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
