package com.zhouc.enums;

/**
 * Created by Administrator on 2017/9/8.
 */
public enum ResultEnum {
    SUCCESS("200", "success"),
    SYSTEM_EXCEPTION("500", "系统异常"),
    GIRL_AGE_SMALL_EXCEPTION("501", "年龄过小"),
    GIRL_AGE_LARGE_EXCEPTION("502", "年龄过大"),
    GIRL_VALIDATE_EXCEPTION("503", "数据校验失败");

    private String code;
    private String mes;

    ResultEnum(String code, String mes) {
        this.code = code;
        this.mes = mes;
    }

    public String getCode() {
        return code;
    }

    public String getMes() {
        return mes;
    }
}
