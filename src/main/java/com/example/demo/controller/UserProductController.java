package com.example.demo.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "UserProductController")
@RequestMapping("/users")
public class UserProductController {
	
	@Autowired
	UserService service;
	private static final Logger logger=LoggerFactory.getLogger(UserProductController.class);
	
	/*
	 * @ApiOperation(value = "Register a user")
	 * 
	 * @PostMapping("/register") public ResponseEntity<Employee>
	 * createEmployee(@Valid @RequestBody Employee employee) throws
	 * RecordNotFoundException { Employee updated =
	 * service.createOrUpdateEmployee(employee); return new
	 * ResponseEntity<Employee>(updated, new HttpHeaders(), HttpStatus.OK); }
	 */
	


}
