package com.tdu.web.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tdu.pojo.User;
import com.tdu.service.SimpleMongoService;

@Controller
@RequestMapping("/mongo")
public class MongoWebController {

	private static final Logger log=LoggerFactory.getLogger(MongoWebController.class);
	@Autowired
	private SimpleMongoService simpleMongoService;

	@RequestMapping("/add")
	@ResponseBody
	public String save() {
		log.info("start insert");
		for(int i=0;i<20;i++){
			User user = new User();
			user.setId(UUID.randomUUID().toString());
			user.setUname("测试");
			user.setUpwd("开始计划");
			simpleMongoService.save(user);
		}
		log.info("end   insert");
		return "ok";
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public String findAll() {
		return "ok";
	}
}

