package org.allen.dubbo.api;

import java.io.Serializable;

public class User implements Serializable {

    private Long userId;
    private String username;
    private String sex;
    private Integer age;

    public User() {

    }

    public User(Long userId, String username, String sex, Integer age) {
        this.userId = userId;
        this.username = username;
        this.sex = sex;
        this.age = age;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
