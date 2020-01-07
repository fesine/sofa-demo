package com.example.sofaboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

//@ImportResource({"classpath:sofa-providers.xml","classpath:sofa-consumers.xml"})
@SpringBootApplication
public class SofaBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(SofaBootDemoApplication.class);
		ApplicationContext applicationContext = application.run(args);
		//SpringApplication.run(SofaBootDemoApplication.class, args);

		//HelloSyncService helloSyncService = (HelloSyncService) applicationContext.getBean(
		//		"helloSyncServiceReference");
		//System.out.println(helloSyncService.saySync("sync"));


	}

}
