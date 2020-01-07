package org.example.provider;

import com.alipay.sofa.rpc.config.ProviderConfig;
import com.alipay.sofa.rpc.config.ServerConfig;
import org.example.service.HelloService;
import org.example.service.impl.HelloServiceImpl;

/**
 * @description: 类描述
 * @author: fesine
 * @createTime:2020/1/7
 * @update:修改内容
 * @author: fesine
 * @updateTime:2020/1/7
 */
public class QuickStartServer {

    public static void main(String[] args) {
        //服务端配置
        ServerConfig serverConfig = new ServerConfig()
                .setProtocol("bolt")
                .setPort(12200)
                .setDaemon(false);
        //提供者配置
        ProviderConfig<HelloService> providerConfig = new ProviderConfig<HelloService>()
                .setInterfaceId(HelloService.class.getName())
                .setRef(new HelloServiceImpl())
                .setServer(serverConfig);
        providerConfig.export();

    }
}
