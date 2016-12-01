package org.allen.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class ProviderBootstrap {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        context.start();

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
