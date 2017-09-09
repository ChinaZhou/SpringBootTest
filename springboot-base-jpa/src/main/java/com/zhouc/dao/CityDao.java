package com.zhouc.dao;

import com.zhouc.dto.City;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2017/9/9.
 */
public interface CityDao {

    public City findByName(@Param("cityName") String cityName);
}
