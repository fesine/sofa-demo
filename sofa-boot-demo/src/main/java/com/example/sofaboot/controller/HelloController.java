package com.example.sofaboot.controller;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import com.example.sofaboot.service.HelloSyncService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 类描述
 * @author: fesine
 * @createTime:2020/1/7
 * @update:修改内容
 * @author: fesine
 * @updateTime:2020/1/7
 */
@RestController
@RequestMapping("/v1")
public class HelloController {

    @SofaReference(interfaceType = HelloSyncService.class,binding = @SofaReferenceBinding(bindingType = "bolt"))
    HelloSyncService helloSyncService;

    @GetMapping("/hello")
    public String hello(){
        String world = helloSyncService.saySync("world");
        return world;
    }
}
