package com.neo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * TODO 提供者
 * 添加@EnableDiscoveryClient注解后，
 * 
 * 项目就具有了服务注册的功能
 * 
 * @author 01383184
 *
 */
@SpringBootApplication
//TODO 启用服务注册与发现
@EnableDiscoveryClient
public class ProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}
}
