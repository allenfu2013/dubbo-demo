package org.allen.dubbo.consumer;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import org.allen.dubbo.service.HelloWorldService;

public class HelloWorldConsumer {

    public static void main(String[] args) {
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
}
