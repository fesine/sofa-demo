package org.example.service.impl;

import org.example.service.HelloService;

/**
 * @description: 类描述
 * @author: fesine
 * @createTime:2020/1/7
 * @update:修改内容
 * @author: fesine
 * @updateTime:2020/1/7
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String string) {
        System.out.println("Server receive: "+ string);
        return "hello " + string +"!";
    }
}
