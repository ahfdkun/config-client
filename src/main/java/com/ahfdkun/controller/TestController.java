package com.ahfdkun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// 通过http://localhost:7002/refresh接口进行动态刷新配置
// 也可以通过github中的webhooks功能配置refresh地址动态刷新配置(需要使用ngrok工具反向代理工具实现本地web应用暴露在公网上)
@RefreshScope
@RestController
public class TestController {
	@Value("${from}")
	private String from;
	
	@Value("${name:undefined}")
	private String name;

	@Autowired
	private Environment env;

	@RequestMapping("/from")
	public String from() {
		System.out.println(env.getProperty("from", "undefined"));
		System.out.println(env.getProperty("name"));
		return this.from + "--------->" + this.name;
	}

}
