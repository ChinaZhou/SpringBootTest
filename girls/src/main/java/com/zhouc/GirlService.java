package com.zhouc;

import java.util.List;

/**
 * Created by Administrator on 2017/9/7.
 */
public interface GirlService {

    public List<Girl> findAll();

    public Girl addOne(Girl girl);

    public List<Girl> findByNameAndAge(String name, Integer age);

    public void deleteById(Integer id);

    public Girl updateOne(Girl girl);

    public Girl findById(Integer id);

    public void addTwo();
}
