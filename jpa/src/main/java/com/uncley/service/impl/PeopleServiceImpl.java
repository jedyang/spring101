package com.uncley.service.impl;

import com.uncley.entity.People;
import com.uncley.repository.PeopleRepository;
import com.uncley.service.PeopleService;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yunsheng
 * @title: PeopleServiceImpl
 * @projectName spring101
 * @description: TODO
 * @date 2019/3/19 15:14
 */
public class PeopleServiceImpl implements PeopleService{

    @Autowired
    private PeopleRepository peopleRepository;

    @Override
    public People insertOne(People p) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public People findById(Integer id) {
        return null;
    }

    @Override
    public People modifyOne(People p) {
        return null;
    }
}
