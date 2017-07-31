package com.activiti.pojo;

import java.io.Serializable;

/**
 * Created by 12490 on 2017/8/1.
 */
public class User implements Serializable{
    private int id;
    private String name;
    private int age;
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
