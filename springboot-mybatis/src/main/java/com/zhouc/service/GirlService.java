package com.zhouc.service;

import com.zhouc.dto.Girl;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2017/9/9.
 */
public interface GirlService {

    public Girl findByName(@Param("cityName") String cityName);
}
