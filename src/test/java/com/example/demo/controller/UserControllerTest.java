package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.example.demo.dto.SearchProductInformation;
import com.example.demo.serviceimpl.UsersService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserControllerTest {

	@Mock
	UsersService userService;

	@InjectMocks
	UserController userController;
	
	
	@Test
	public void testSearchByProductName()
	{
		List<SearchProductInformation> productsInfo=new ArrayList<SearchProductInformation>();
	}

}
