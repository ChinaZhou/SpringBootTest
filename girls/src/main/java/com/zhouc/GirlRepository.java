package com.zhouc;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2017/9/7.
 */
public interface GirlRepository extends JpaRepository<Girl, Integer> {

    public List<Girl> findByNameAndAge(String name, Integer age);
}

