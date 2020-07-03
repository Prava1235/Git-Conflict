package com.example.demo.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.example.demo.appconstant.ApplicationConstants;
import com.example.demo.dto.ResponseDto;
import com.example.demo.dto.SearchProductInformation;
import com.example.demo.dto.logindto;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.exception.InvalidUser;
import com.example.demo.exception.ProductException;
import com.example.demo.repostiory.ProductRepository;
import com.example.demo.repostiory.UserRepository;

@Service
public class UserServiceImpl implements UsersService {

	@Autowired
	UserRepository userRepo;

	@Autowired
	ProductRepository productRepo;

	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	ModelMapper modelMapper = new ModelMapper();

	@Override
	public ResponseDto login(logindto loginDto) {

		logger.info("validating the user login information in the userserviceimplementation");

		if (loginDto.getUserName() == null || loginDto.getPassword() == null) {
			ResponseDto response = new ResponseDto();
			response.setMessage("please enter the username and password,it cannot be empty");
			response.setCode(HttpStatus.BAD_REQUEST.value());
			return response;
		}

		User userEntity = userRepo.findByName(loginDto.getUserName());

		if (userEntity == null) {
			ResponseDto response = new ResponseDto();
			response.setMessage("please enter valid user details");
			response.setCode(HttpStatus.BAD_REQUEST.value());

			return response;

		}

		if (loginDto.getUserName().equals(userEntity.getName())
				&& loginDto.getPassword().equals(userEntity.getPassword())) {
			ResponseDto vresponse = new ResponseDto();
			vresponse.setMessage("user logined successfully");
			vresponse.setCode(HttpStatus.ACCEPTED.value());

			return vresponse;

		} else {
			throw new InvalidUser(ApplicationConstants.LOGIN_FAILURE);

		}

	}

	@Override
	public List<SearchProductInformation> getProductsBySearh(String productName) {

		if (productName == null) {
			throw new ProductException(ApplicationConstants.PRODUCT_NAME_NULL);
		}

		List<Product> productsInfo = productRepo.findByNameContains(productName);

		logger.info("fetching the all products information in user service Impl");
		System.out.println(productsInfo);
		List<SearchProductInformation> searchproducts = new ArrayList<SearchProductInformation>();

		for (Product productInfo : productsInfo) {
			SearchProductInformation searchproduct = modelMapper.map(productInfo, SearchProductInformation.class);

			logger.info("Gather the all production information in model mapper");

			searchproducts.add(searchproduct);
		}

		return searchproducts;
	}

}
