package org.allen.dubbo.consumer;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import org.allen.dubbo.service.HelloWorldService;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class HelloWorldConsumer {

    private static Method method = null;
    private static Object object = null;

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        init();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("*** press '1' to call dubbo , 'q' to quit ****");
            String in = sc.next();
            if ("1".equals(in)) {
                callDubbo();
            } else if ("q".equals(in)) {
                System.out.println("*** bye! bye! ****");
                break;
            }
        }
    }

    public static void normal() {
        ApplicationConfig applicationConfig = new ApplicationConfig("hello-consumer");

        RegistryConfig registryConfig = new RegistryConfig("zookeeper://172.16.23.68:2184");

        ReferenceConfig<HelloWorldService> referenceConfig = new ReferenceConfig<HelloWorldService>();
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setRegistry(registryConfig);
        referenceConfig.setInterface(HelloWorldService.class);
        referenceConfig.setVersion("1.0.0");

        HelloWorldService helloWorldService = referenceConfig.get();
        System.out.println(helloWorldService.hello("dubbo-api"));
    }

    public static void init() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
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

        object = referenceConfig.get();
        method = clazz.getMethod(methodName, String.class);
    }

    public static void callDubbo() throws InvocationTargetException, IllegalAccessException {
        Object result = method.invoke(object, "dubbo-api");
        System.out.println(result);
    }
}
