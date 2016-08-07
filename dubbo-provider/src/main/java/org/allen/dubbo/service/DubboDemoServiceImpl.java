package org.allen.dubbo.service;

import org.allen.dubbo.api.DubboDemoService;

import java.util.Date;

public class DubboDemoServiceImpl implements DubboDemoService {

    public String helloDubbo(String msg) {
        System.out.println("receive dubbo request " + new Date().toLocaleString());
        try {
            // 测试consumer的timeout以及重试机制
            Thread.sleep(5000);
        } catch (Exception e) {

        }
        return "hello " + msg;
    }
}
