package com.xning.fastdfs.user.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", length = 10)
    private String name;

    @Column(name = "heard_pic")
    private String heardPic;

    @Column(name = "sex", length = 2)
    private String sex;

    @Column(name = "age", length = 2)
    private int age;

}
