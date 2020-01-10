package com.example.sofaboot.controller;

import com.alibaba.dubbo.demo.test.IService;
import com.alibaba.dubbo.demo.dap.DapService;
import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import com.example.sofaboot.service.HelloSyncService;
import org.apache.dubbo.demo.DemoService;
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

    @SofaReference(interfaceType = HelloSyncService.class,binding = @SofaReferenceBinding(bindingType = "dubbo"))
    HelloSyncService helloSyncService;

    @SofaReference(interfaceType = DapService.class,
            binding = @SofaReferenceBinding(bindingType = "dubbo"),
            uniqueId = "AS_DAP_SERVICE_A", jvmFirst = false)
    private DapService dapService;

    @SofaReference(interfaceType = DemoService.class,
            binding = @SofaReferenceBinding(bindingType = "dubbo"),
            uniqueId = "demoService1", jvmFirst = false)
    private DemoService demoService;

    @SofaReference(interfaceType = IService.class,
            binding = @SofaReferenceBinding(bindingType = "dubbo"),
            uniqueId = "AS_TEST_SERVICE_A", jvmFirst = false)
    private IService iService;

    @GetMapping("/hello")
    public String hello(){
        String world = helloSyncService.saySync("world");
        return world;
    }

    /**
     * dap修改版本dubbo协议测试
     * @return
     */
    @GetMapping("/dap")
    public String dap(){
        dapService.handle("dap");
        return null;
    }

    /**
     * dubbo 2.7.3测试
     * @return
     */
    @GetMapping("/demo")
    public String demoService(){
        return demoService.sayHello("zookeeper");
    }

    /**
     * dubbox 2.8.4原生测试
     * @return
     */
    @GetMapping("/iService")
    public String iService(){
        iService.execute("iService");
        return null;
    }
}
