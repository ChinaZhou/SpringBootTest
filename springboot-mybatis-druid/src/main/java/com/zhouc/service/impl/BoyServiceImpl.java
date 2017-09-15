package com.zhouc.service.impl;

import com.zhouc.dao.boy.BoyDao;
import com.zhouc.dao.girl.GirlDao;
import com.zhouc.dto.Boy;
import com.zhouc.dto.Girl;
import com.zhouc.service.BoyService;
import com.zhouc.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/9/9.
 */
@Service
public class BoyServiceImpl implements BoyService {

    @Autowired
    private BoyDao boyDao;

    @Override
    public Boy findByName(String cityName) {
        return boyDao.findByName(cityName);
    }
}
