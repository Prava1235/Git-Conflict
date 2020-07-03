package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ResponseDto;
import com.example.demo.dto.SearchProductInformation;
import com.example.demo.dto.logindto;

@Service
public interface UsersService {

	public ResponseDto login(logindto loginDto);

	public List<SearchProductInformation> getProductsBySearh(String productName);

}
