package org.allen.dubbo.service;

public class HelloWorldServiceImpl implements HelloWorldService {
    @Override
    public String hello(String msg) {
        System.out.println(String.format("receive dubbo call, msg: %s", msg));
        return "hello " + msg;
    }
}
