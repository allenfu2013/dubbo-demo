package org.allen.dubbox;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Bootstrap {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:dubbox-provider.xml");
        context.start();
        System.out.println("服务已经启动...");
        System.out.println("输入任意字符退出:");
        System.in.read();
    }
}
