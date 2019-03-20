package com.uncley.entity;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @作者 UncleY
 * @时间 2019/3/18
 * @描述
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity //表示对应数据库中一个表
public class People {
    @Id //主键
    @GeneratedValue  //自增
    private int id;
    private String name;
    private int age;

    @OneToMany
    private Set<HomeAddress> addresses;
}
