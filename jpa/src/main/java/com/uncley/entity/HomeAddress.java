package com.uncley.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

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
@Table(name = "t_homeAddress") //可以自定义表名，如果不写这里默认生成的表名是home_address
public class HomeAddress {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO) // 自增主键，默认就是AUTO
    //JPA提供的四种标准用法为TABLE,SEQUENCE,IDENTITY,AUTO.
    //TABLE：使用一个特定的数据库表格来保存主键。
    //SEQUENCE：根据底层数据库的序列来生成主键，条件是数据库支持序列。
    //IDENTITY：主键由数据库自动生成（主要是自动增长型）
    //AUTO：框架自动选择
    @Column(name="id",columnDefinition="int(30) comment '自增主键'")
    private Integer id;

    @Column(name="peopleId",nullable=false,columnDefinition="int(20) comment 'peopleId'")
    private Integer peopleId;

    @Transient //此字段不与数据库关联
    @Version//此字段加上乐观锁
    @Column(length=64,name="address",nullable=false,columnDefinition="varchar(64) unique comment '地址'")
    private String address;

}
