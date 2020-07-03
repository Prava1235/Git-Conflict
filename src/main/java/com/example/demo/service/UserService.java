package com.example.demo.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repostiory.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final static Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User save(User user) {
		 logger.info("saving the product informartion in Cart Table.");
		return userRepository.save(user);
	}
	
	public Optional<User> findUser(long id) {
		 logger.info("finding user in DB for ordering");
		return userRepository.findById(id);
	}
}
