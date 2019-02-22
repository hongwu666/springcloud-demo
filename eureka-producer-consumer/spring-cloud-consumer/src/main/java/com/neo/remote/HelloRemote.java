package com.neo.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * TODO
 * 
 * 1.name:远程服务名，及spring.application.name配置的名称
 * 
 * 2.feign带负载均衡,当有同一服务多个不同端口时，会交替自动轮询到每个服务端来处理
 * @author 01383184
 *
 */
@FeignClient(name= "spring-cloud-producer")
public interface HelloRemote {
	
	/**
	 * TODO
	 * 
	 * 此类中的方法和远程服务中contoller中的方法名和参数需保持一致
	 * 
	 * 即 /hello   @RequestParam(value = "name") 必须匹配远程服务
	 * 
	 * @param name
	 * @return
	 */
    @RequestMapping(value = "/hello")
    public String hello(@RequestParam(value = "name") String name);


}
