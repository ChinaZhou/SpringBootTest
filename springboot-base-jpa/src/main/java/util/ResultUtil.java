package util;

import com.zhouc.dto.Result;
import com.zhouc.enums.ResultEnum;

/**
 * Created by Administrator on 2017/9/8.
 */
public class ResultUtil {

    public static Result success(Object data) {
        Result res = new Result();
        res.setCode(ResultEnum.SUCCESS.getCode());
        res.setMes(ResultEnum.SUCCESS.getMes());
        res.setData(data);
        return res;
    }

    public static Result success() {
        Result res = new Result();
        res.setCode(ResultEnum.SUCCESS.getCode());
        res.setMes(ResultEnum.SUCCESS.getMes());
        return res;
    }

    public static Result error(ResultEnum resultEnum) {
        Result res = new Result();
        res.setCode(resultEnum.getCode());
        res.setMes(resultEnum.getMes());
        return  res;
    }
}
