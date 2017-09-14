package com.zhouc.service;

import com.zhouc.dto.Girl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/9/9.
 */
public interface GirlService {

    Girl findByName(@Param("cityName") String cityName);

    List<Girl> findAll();

    Girl findById(@Param("id") Integer id);
}
