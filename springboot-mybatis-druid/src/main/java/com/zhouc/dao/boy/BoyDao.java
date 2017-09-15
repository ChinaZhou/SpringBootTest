package com.zhouc.dao.boy;

import com.zhouc.dto.Boy;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/9/15.
 */
@Repository
public interface BoyDao {

    Boy findByName(@Param("name") String name);
}
