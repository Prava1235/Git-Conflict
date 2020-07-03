package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseDto;
import com.example.demo.dto.SearchProductInformation;
import com.example.demo.dto.logindto;
import com.example.demo.service.UserService;
import com.example.demo.serviceimpl.UsersService;

@RestController
public class UserController {

	@Autowired
	UsersService userService;

	Logger logger = LoggerFactory.getLogger(UserController.class);

	/**
	 * Here we taking login information from the user
	 * 
	 * @param userName:String
	 * @param password:String
	 *
	 *                        Once validating the loging details we return the
	 *                        response to the user
	 * 
	 * @return message:String
	 * @return ResponseCode:int
	 *
	 */
	@PostMapping
	public ResponseDto authenticate(@RequestBody logindto loginDto) {

		logger.info("user login informatio in usercontroller");
		return userService.login(loginDto);

	}

	@GetMapping("/users/products/{productName}")
	public List<SearchProductInformation> searchProductInfo(@PathVariable("productName") String productName) {

		logger.info("user serachs the products");
		return userService.getProductsBySearh(productName);

	}

}
