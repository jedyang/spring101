package com.uncley.repository;

import com.uncley.DemoApplication;
import com.uncley.entity.People;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class PeopleRepositoryTest {

    @Autowired
    private PeopleRepository peopleRepository;

    @Test
    public void insertOne() {
        People p = new People();
        p.setName("uncley");
        p.setAge(30);
        People result = peopleRepository.save(p);

        System.out.println("insertOne result : " + result);

    }

    @Test
    public void deleteById() {

    }

    @Test
    public void findById() {

    }

    @Test
    public void modifyOne() {

    }

}