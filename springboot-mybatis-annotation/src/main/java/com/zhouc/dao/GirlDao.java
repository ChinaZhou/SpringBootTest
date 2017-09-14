package com.zhouc.dao;

import com.zhouc.dto.Girl;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/9/9.
 */
@Mapper
@Repository
public interface GirlDao {

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "age", column =  "age")
    } )

    @Select("select * from girl where name = #{name}")
    Girl findByName(@Param("name") String name);

    @Select("select * from girl")
    List<Girl> findAll();

    @Select("select * from girl where id = #{id}")
    Girl findById(@Param("id") Integer id);
}
