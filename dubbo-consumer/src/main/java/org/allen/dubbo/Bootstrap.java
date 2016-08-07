package org.allen.dubbo;

import org.allen.dubbo.api.DubboDemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class Bootstrap {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        DubboDemoService dubboDemoService = (DubboDemoService)context.getBean("dubboDemoService");
        System.out.println("start to call dubbo " + new Date().toLocaleString());
        System.out.println(dubboDemoService.helloDubbo("dubbo1"));
        System.out.println("end to call dubbo " + new Date().toLocaleString());
    }
}
