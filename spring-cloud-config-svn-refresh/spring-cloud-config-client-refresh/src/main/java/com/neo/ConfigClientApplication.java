package com.neo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringCloudConfig分服务端和客户端，服务端负责将git（svn）中存储的配置文件发布成REST接口，
 * 客户端可以从服务端REST接口获取配置. 但客户端并不能主动感知到配置的变化，从而主动去获取新的配置.
 * 客户端如何去主动获取新的配置信息呢，springcloud已经给我们提供了解决方案，每个客户端通过POST方法触发各自的/refresh。
 * 
 * ----1、添加依赖
 * 增加了spring-boot-starter-actuator包，spring-boot-starter-actuator是一套监控的功能，
 * 可以监控程序在运行时状态，其中就包括/refresh的功能
 * 
 * 2、 开启更新机制
 * 
 * 需要给加载变量的类上面加载@RefreshScope，在客户端执行/refresh的时候就会更新此类下面的变量值
 * 
 * 3.先執行 post http://localhost:8002/refresh 就更新了curl -X POST
 * http://localhost:8002/refresh
 * 
 * ----but 每次手动刷新客户端也很麻烦，有没有什么办法只要提交代码就自动调用客户端来更新呢，github的webhook是一个好的办法。
 * 
 * WebHook
 * 
 * WebHook是当某个事件发生时，通过发送httppost请求的方式来通知信息接收方。Webhook来监测你在Github.com上的各种事件，
 * 最常见的莫过于push事件。
 * 如果你设置了一个监测push事件的Webhook，那么每当你的这个项目有了任何提交，这个Webhook都会被触发，这时Github就会发送一个HTTP
 * POST请求到你配置好的地址。
 * 如此一来，你就可以通过这种方式去自动完成一些重复性工作，比如，你可以用Webhook来自动触发一些持续集成（CI）工具的运作，比如Travis
 * CI；又或者是通过 Webhook 去部署你的线上服务器。下图就是github上面的webhook配置。
 * 
 * Payload URL ：触发后回调的URL.
 * 
 * Content type ：数据格式，两种一般使用json
 * 
 * Secret：用作给POST的body加密的字符串。采用HMAC算法
 * 
 * events ：触发的事件列表。
 * 
 * events事件类型
 * 
 * push 仓库有push时触发。默认事件
 * 
 * create 当有分支或标签被创建时触发
 * 
 * delete 当有分支或标签被删除时触发
 * 
 * svn也有类似的hook机制，每次提交后会触发post-commit脚本，我们可以在这里写一些post请求
 * 
 * 这样我们就可以利用hook的机制去触发客户端的更新，但是当客户端越来越多的时候hook支持的已经不够优雅，另外每次增加客户端都需要改动hook也是不现实的
 * 。其实Spring Cloud给了我们更好解决方案，后面介绍
 * 
 * @author 01383184
 *
 */
@SpringBootApplication
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}
}
