package org.allen.dubbo.service;

public class HelloWorldServiceImpl implements HelloWorldService {
    @Override
    public String hello(String msg) {
        return "hello " + msg;
    }
}
