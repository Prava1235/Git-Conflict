package com.example.demo.repostiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	public List<Product> findByNameContains(String productName);

}
