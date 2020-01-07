package org.example.consumer;

import com.alipay.sofa.rpc.config.ConsumerConfig;
import org.example.service.HelloService;

/**
 * @description: 类描述
 * @author: fesine
 * @createTime:2020/1/7
 * @update:修改内容
 * @author: fesine
 * @updateTime:2020/1/7
 */
public class QuickStartClient {

    public static void main(String[] args) {
        ConsumerConfig<HelloService> consumerConfig = new ConsumerConfig<HelloService>()
                .setInterfaceId(HelloService.class.getName())
                .setProtocol("bolt")
                .setDirectUrl("bolt://127.0.0.1:12200");
        HelloService service = consumerConfig.refer();
        while (true) {
            System.out.println(service.sayHello("world"));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
