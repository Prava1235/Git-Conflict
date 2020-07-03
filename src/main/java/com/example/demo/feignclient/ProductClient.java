package com.example.demo.feignclient;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Product;

@FeignClient(value="order-service", url="http://localhost:8081/demo/orders")
//@FeignClient(name="http://ORDER-SERVICE/demo/orders")
public interface ProductClient {
	
	@GetMapping("")
	public List<Product> getAll();
	
	@GetMapping("/{productId}")
	public Optional<Product> getProduct(@PathVariable("productId") long userId);
	
}
