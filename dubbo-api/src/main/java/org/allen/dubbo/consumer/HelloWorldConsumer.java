package org.allen.dubbo.consumer;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import org.allen.dubbo.service.HelloWorldService;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HelloWorldConsumer {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        reflect();

        System.out.println("*** press any key to quit ****");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("*** bye! bye! ****");
    }

    public static void normal() {
        ApplicationConfig applicationConfig = new ApplicationConfig("hello-consumer");

        RegistryConfig registryConfig = new RegistryConfig("zookeeper://172.16.23.68:2184");

        ReferenceConfig<HelloWorldService> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setRegistry(registryConfig);
        referenceConfig.setInterface(HelloWorldService.class);
        referenceConfig.setVersion("1.0.0");

        HelloWorldService helloWorldService = referenceConfig.get();
        System.out.println(helloWorldService.hello("dubbo-api"));
    }

    public static void reflect() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String className = "org.allen.dubbo.service.HelloWorldService";
        String methodName = "hello";

        ApplicationConfig applicationConfig = new ApplicationConfig("hello-consumer");

        RegistryConfig registryConfig = new RegistryConfig("zookeeper://172.16.23.68:2184");

        Class clazz = Class.forName(className);

        ReferenceConfig referenceConfig = new ReferenceConfig();
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setRegistry(registryConfig);
        referenceConfig.setInterface(clazz);
        referenceConfig.setVersion("1.0.0");

        Object object = referenceConfig.get();
        Method method = clazz.getMethod(methodName, String.class);
        Object result = method.invoke(object, "dubbo-api");
        System.out.println(result);
    }
}
