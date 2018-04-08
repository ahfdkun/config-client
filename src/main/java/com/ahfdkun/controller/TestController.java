package com.ahfdkun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
