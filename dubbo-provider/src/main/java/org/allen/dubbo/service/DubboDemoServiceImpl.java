package org.allen.dubbo.service;

import org.allen.dubbo.api.DemoException;
import org.allen.dubbo.api.DubboDemoService;
import org.allen.dubbo.api.User;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DubboDemoServiceImpl implements DubboDemoService {

    public String helloDubbo(String msg) {
        System.out.println("### helloDubbo, msg=" + msg);
        return "hello " + msg;
    }

    @Override
    public User getUserById(Long userId) {
        System.out.println("#### getUserById, userId=" + userId);
        User user = new User(userId, "allen", "Male", 30);
        try {
            // 测试consumer的timeout以及重试机制
            Thread.sleep(3000);
        } catch (Exception e) {

        }
        return user;
    }

    @Override
    public List<User> getUserByName(String username) {
        System.out.println("#### getUserByName, username=" + username);
        User user1 = new User(1L, username, "Male", 20);
        User user2 = new User(2L, username, "Female", 10);
        List<User> list = new ArrayList<User>(2);
        list.add(user1);
        list.add(user2);
        return list;
    }

    @Override
    public void createUser(User user) {
        if (user == null) throw new DemoException("user is null");
        System.out.println("#### createUser, user=" + user.toString());
    }
}
