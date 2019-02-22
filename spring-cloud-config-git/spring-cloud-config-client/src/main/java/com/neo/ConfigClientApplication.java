package com.neo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 注意
 * 
 * 上面这些与spring-cloud相关的属性必须配置在bootstrap.properties中，config部分内容才能被正确加载.
 * 因为config的相关配置会先于application.properties，而bootstrap.
 * properties的加载也是先于application.properties。
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
