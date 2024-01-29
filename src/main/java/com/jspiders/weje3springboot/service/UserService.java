package com.jspiders.weje3springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.weje3springboot.pojo.UserEntity;
import com.jspiders.weje3springboot.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	

}
