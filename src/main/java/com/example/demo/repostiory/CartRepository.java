package com.example.demo.repostiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Product;

public interface CartRepository extends JpaRepository<Cart, Long>{

	@Query("select c from Cart c where c.userId = :userId")
	 public List<Cart> findProductsByUserId(@Param("userId") long userId);
}
