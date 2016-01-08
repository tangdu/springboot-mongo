package com.tdu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.tdu.pojo.User;

@Service
public class SimpleMongoService {
	@Autowired 
	private MongoTemplate mongoTemplate;
	
	public void save(User user){
		mongoTemplate.save(user, "tdu");
	}
}
