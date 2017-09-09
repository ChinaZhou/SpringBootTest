package com.zhouc.service;

import com.zhouc.dto.City;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2017/9/9.
 */
public interface CityService {

    public City findByName(@Param("cityName") String cityName);
}
