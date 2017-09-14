package com.zhouc.service.impl;

import com.zhouc.dao.GirlDao;
import com.zhouc.dto.Girl;
import com.zhouc.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/9/9.
 */
@Service
public class GirlServiceImpl implements GirlService {

    @Autowired
    private GirlDao girlDao;

    @Override
    public Girl findByName(String cityName) {
        return girlDao.findByName(cityName);
    }

    @Override
    public List<Girl> findAll() {
        return girlDao.findAll();
    }

    @Override
    public Girl findById(Integer id) {
        return girlDao.findById(id);
    }
}
