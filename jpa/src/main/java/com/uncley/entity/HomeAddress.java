package com.uncley.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author uncleY
 * @description: TODO
 * @date 2019/3/20 17:16
 */
@NoArgsConstructor // 无参构造器
@AllArgsConstructor // 全参构造器
@ToString
@Getter
@Setter
@Entity(name = "HomeAddress")
public class HomeAddress {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO) // 自增主键，默认就是AUTO
    @Column(name="id",columnDefinition="int(30) comment '自增主键'")
    private Integer id;

    @Column(name="peopleId",nullable=false,columnDefinition="int(20) comment 'peopleId'")
    private Integer peopleId;

    @Column(length=64,name="address",nullable=false,columnDefinition="varchar(64) unique comment '地址'")
    private String address;

}
