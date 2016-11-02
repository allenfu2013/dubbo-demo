package org.allen.dubbox;

import org.allen.dubbox.api.User;
import org.allen.dubbox.api.UserRestService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bootstrap {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:dubbox-consumer.xml");
        context.start();
        UserRestService userRestService = context.getBean(UserRestService.class);
        User user = userRestService.getUser(1L);
        System.out.println(user.getName());
    }
}
