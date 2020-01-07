package com.example.sofaboot.api;

import com.alipay.sofa.rpc.boot.runtime.param.BoltBindingParam;
import com.alipay.sofa.runtime.api.aware.ClientFactoryAware;
import com.alipay.sofa.runtime.api.client.ClientFactory;
import com.alipay.sofa.runtime.api.client.ServiceClient;
import com.alipay.sofa.runtime.api.client.param.BindingParam;
import com.alipay.sofa.runtime.api.client.param.ServiceParam;
import com.example.sofaboot.service.HelloSyncService;
import com.example.sofaboot.service.impl.HelloSyncServiceImpl;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 类描述
 * @author: fesine
 * @createTime:2020/1/7
 * @update:修改内容
 * @author: fesine
 * @updateTime:2020/1/7
 */
public class ProviderClientFactoryBean implements ClientFactoryAware {
    private ClientFactory clientFactory;

    @Override
    public void setClientFactory(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    @PostConstruct
    public void export(){
        //ServiceClient client = clientFactory.getClient(ServiceClient.class);
        //ServiceParam serviceParam = new ServiceParam();
        //serviceParam.setInterfaceType(HelloSyncService.class);
        //serviceParam.setInstance(new HelloSyncServiceImpl());
        //ArrayList<BindingParam> bindingParams = new ArrayList<BindingParam>();
        //
        //BindingParam bindingParam = new BoltBindingParam();
        //bindingParams.add(bindingParam);
        //serviceParam.setBindingParams(bindingParams);
        //client.service(serviceParam);
        ServiceClient serviceClient = clientFactory.getClient(ServiceClient.class);

        ServiceParam serviceParam = new ServiceParam();
        serviceParam.setInterfaceType(HelloSyncService.class);
        serviceParam.setInstance(new HelloSyncServiceImpl());

        List<BindingParam> params = new ArrayList<BindingParam>();
        BindingParam serviceBindingParam = new BoltBindingParam();
        params.add(serviceBindingParam);
        serviceParam.setBindingParams(params);

        serviceClient.service(serviceParam);

    }

}
