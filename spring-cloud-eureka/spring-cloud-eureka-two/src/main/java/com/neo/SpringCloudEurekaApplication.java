package com.neo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * TODO 注册中心 集群两机
 * 
 * 注册中心这么关键的服务，如果是单点话，遇到故障就是毁灭性的。
 * 
 * 在一个分布式系统中，服务注册中心是最重要的基础部分，理应随时处于可以提供服务的状态。
 * 
 * 
 * 为了维持其可用性，使用集群是很好的解决方案。
 * 
 * Eureka通过互相注册的方式来实现高可用的部署，所以我们只需要将EurekeServer配置其他可用的serviceUrl就能实现高可用部署。
 * 
 * @author 01383184
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class SpringCloudEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaApplication.class, args);
	}
}
