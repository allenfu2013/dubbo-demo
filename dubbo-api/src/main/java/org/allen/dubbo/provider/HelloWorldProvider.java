package org.allen.dubbo.provider;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import org.allen.dubbo.service.HelloWorldService;
import org.allen.dubbo.service.HelloWorldServiceImpl;

import java.io.IOException;

public class HelloWorldProvider {

    public static void main(String[] args) {
        ApplicationConfig applicationConfig = new ApplicationConfig("hello-provider");

        RegistryConfig registryConfig = new RegistryConfig("zookeeper://172.16.23.68:2184");

        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20082);
        protocolConfig.setThreads(10);

        ServiceConfig<HelloWorldService> serviceConfig = new ServiceConfig<HelloWorldService>();
        serviceConfig.setApplication(applicationConfig);
        serviceConfig.setRegistry(registryConfig);
        serviceConfig.setProtocol(protocolConfig);
        serviceConfig.setInterface(HelloWorldService.class);
        serviceConfig.setRef(new HelloWorldServiceImpl());
        serviceConfig.setVersion("1.0.0");
        serviceConfig.export();

        System.out.println("*** press any key to quit ****");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("*** bye! bye! ****");
    }
}
