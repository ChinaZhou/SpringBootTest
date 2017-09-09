package com.zhouc.exception;

import com.zhouc.enums.ResultEnum;

/**
 * Created by Administrator on 2017/9/8.
 */
public class GirlException extends RuntimeException {
    private ResultEnum resultEnum;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMes());
        this.resultEnum = resultEnum;
    }

    public ResultEnum getResultEnum() {
        return resultEnum;
    }

    public void setResultEnum(ResultEnum resultEnum) {
        this.resultEnum = resultEnum;
    }
}
