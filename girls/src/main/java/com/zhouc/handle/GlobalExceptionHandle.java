package com.zhouc.handle;

import com.zhouc.dto.Result;
import com.zhouc.enums.ResultEnum;
import com.zhouc.exception.GirlException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import util.ResultUtil;

/**
 * Created by Administrator on 2017/9/8.
 */
@ControllerAdvice
public class GlobalExceptionHandle {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result errorHandle(Exception e) {
        if (e instanceof GirlException) {
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getResultEnum());
        } else {
            log.error("系统异常 {}", e.getMessage());
            return ResultUtil.error(ResultEnum.SYSTEM_EXCEPTION);
        }

    }
}
