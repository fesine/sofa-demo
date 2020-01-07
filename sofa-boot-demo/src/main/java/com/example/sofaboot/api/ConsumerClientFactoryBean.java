package com.example.sofaboot.api;

import com.alipay.sofa.rpc.boot.runtime.param.BoltBindingParam;
import com.alipay.sofa.runtime.api.aware.ClientFactoryAware;
import com.alipay.sofa.runtime.api.client.ClientFactory;
import com.alipay.sofa.runtime.api.client.ReferenceClient;
import com.alipay.sofa.runtime.api.client.param.BindingParam;
import com.alipay.sofa.runtime.api.client.param.ReferenceParam;
import com.example.sofaboot.service.HelloSyncService;

/**
 * @description: 类描述
 * @author: fesine
 * @createTime:2020/1/7
 * @update:修改内容
 * @author: fesine
 * @updateTime:2020/1/7
 */
public class ConsumerClientFactoryBean implements ClientFactoryAware {
    private ClientFactory clientFactory;

    @Override
    public void setClientFactory(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    public void refer(){
        ReferenceClient client = clientFactory.getClient(ReferenceClient.class);
        ReferenceParam<HelloSyncService> referenceParam = new ReferenceParam<>();
        referenceParam.setInterfaceType(HelloSyncService.class);
        BindingParam bindingParam = new BoltBindingParam();
        referenceParam.setBindingParam(bindingParam);
        HelloSyncService reference = client.reference(referenceParam);
        reference.saySync("client api");
    }
}
