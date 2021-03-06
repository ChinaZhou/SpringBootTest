package com.zhouc.service.impl;

import com.zhouc.dto.Girl;
import com.zhouc.enums.ResultEnum;
import com.zhouc.exception.GirlException;
import com.zhouc.repository.GirlRepository;
import com.zhouc.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/9/7.
 */
@Service
public class GirlServiceImpl implements GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Override
    public List<Girl> findAll() {
        return girlRepository.findAll();
    }

    @Override
    public Girl addOne(Girl girl) throws Exception{
        Integer age = girl.getAge();
        if (age < 20) {
            throw new GirlException(ResultEnum.GIRL_AGE_SMALL_EXCEPTION);
        }
        if (age > 45) {
            throw  new GirlException(ResultEnum.GIRL_AGE_LARGE_EXCEPTION);
        }
        return girlRepository.save(girl);
    }

    @Override
    public List<Girl> findByNameAndAge(String name, Integer age) {
        return girlRepository.findByNameAndAge(name, age);
    }

    @Override
    public void deleteById(Integer id) {
        girlRepository.delete(id);
    }

    @Override
    public Girl updateOne(Girl girl) {
        return girlRepository.save(girl);
    }

    @Override
    public Girl findById(Integer id) {
        return girlRepository.findOne(id);
    }

    @Override
    @Transactional
    public void addTwo() {
        Girl girl1 = new Girl();
        girl1.setName("test1");
        girl1.setAge(15);
        girlRepository.save(girl1);

        Girl girl2 = new Girl();
        girl2.setName("test2222");
        girl2.setAge(23);
        girlRepository.save(girl2);

    }
}
