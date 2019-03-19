package com.uncley.service;

import com.uncley.entity.People;

/**
 * @author yunsheng
 * @title: PeopleService
 * @projectName spring101
 * @description: TODO
 * @date 2019/3/19 15:12
 */
public interface PeopleService {

    People insertOne(People p);

    void deleteById(Integer id);

    People findById(Integer id);

    People modifyOne(People p);
}
