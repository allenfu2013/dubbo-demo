package org.allen.dubbox;

import org.allen.dubbox.api.ApiResponseDTO;
import org.allen.dubbox.api.User;
import org.allen.dubbox.api.UserRestService;
import org.allen.dubbox.api.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class Bootstrap {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:dubbox-consumer.xml");
        context.start();

        // dubbo
        UserService userService = (UserService) context.getBean("userService");
        User user = userService.getUser(11L);
        System.out.println("dubbo: username=" + user.getName());

        // rest
        UserRestService userRestService = (UserRestService) context.getBean("userRestService");
        ApiResponseDTO apiResponseDTO = userRestService.getUser(111L);
        Map<String, Object> data = (Map<String, Object>) apiResponseDTO.getData();
        System.out.println("rest: username=" + data.get("username"));
    }
}
