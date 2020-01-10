package com.example.sofaboot.service.impl;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import com.example.sofaboot.service.HelloSyncService;
import org.springframework.stereotype.Component;

/**
 * @description: 类描述
 * @author: fesine
 * @createTime:2020/1/7
 * @update:修改内容
 * @author: fesine
 * @updateTime:2020/1/7
 */
@Component
@SofaService(interfaceType = HelloSyncService.class,bindings = {@SofaServiceBinding(bindingType = "dubbo")})
public class HelloSyncServiceImpl implements HelloSyncService {
    @Override
    public String saySync(String string) {
        return string;
    }
}
