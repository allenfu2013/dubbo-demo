package org.allen.dubbo;

import org.allen.dubbo.api.DemoException;
import org.allen.dubbo.api.DubboDemoService;
import org.allen.dubbo.api.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;
import java.util.Scanner;

public class ConsumerBootstrap {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        DubboDemoService dubboDemoService = (DubboDemoService)context.getBean("dubboDemoService");
        DubboDemoService dubboDemoServiceNew = (DubboDemoService) context.getBean("dubboDemoServiceNew");


        System.out.println(dubboDemoService.helloDubbo("dubbo"));

        try {
            // 测试超时重试
            User user = dubboDemoService.getUserById(11111L);
            System.out.println(user.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        User user = dubboDemoServiceNew.getUserById(22222L);
        System.out.println(user.toString());

        List<User> list = dubboDemoService.getUserByName("allen");
        System.out.println(list);

        dubboDemoService.createUser(new User(3L, "mike", "Male", 20));

        try {
            // 测试接口异常
            dubboDemoService.createUser(null);
        } catch (DemoException e) {
            System.out.println("### error=" + e.getMessage());
        }

        Scanner s = new Scanner(System.in);
        while (true) {
            String text = s.next();
            if ("quit".equals(text)) {
                System.out.println("###### bye!!!");
                break;
            }
        }
    }
}
