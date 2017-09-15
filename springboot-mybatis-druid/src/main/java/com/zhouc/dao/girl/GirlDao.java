package com.zhouc.dao.girl;

import com.zhouc.dto.Girl;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/9/9.
 */
@Repository
public interface GirlDao {

    Girl findByName(@Param("name") String name);
}
