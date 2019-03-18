package com.uncley.repository;

import com.uncley.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @作者 UncleY
 * @时间 2019/3/18
 * @描述
 */
public interface PeopleRepository extends JpaRepository<People, Integer>{

    // 扩展sql
    // 注意这个方法名一定要这样写。这是jpa要求的规范。
    List<People> findByName(String name);
}
