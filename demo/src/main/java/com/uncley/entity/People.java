package com.uncley.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @作者 UncleY
 * @时间 2019/3/18
 * @描述
 */
@Entity //表示对应数据库中一个表
public class People {
    @Id //主键
    @GeneratedValue  //自增
    private int id;
    private String name;
    private int age;

    // 需要一个无参构造函数
    public People() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
