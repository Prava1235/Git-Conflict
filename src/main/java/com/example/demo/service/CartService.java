package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Product;
import com.example.demo.repostiory.CartRepository;

@Service
public class CartService {

	private CartRepository cartRepo;
	private final static Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	public CartService(CartRepository cartRepo) {
		this.cartRepo = cartRepo;
	}

	public void save(Cart cart) {
		logger.info("saving Cart Table.");
		cartRepo.save(cart);
	}

	public void updateOrder(Cart cart) {
		logger.info("placing the Order and saving in DB");
		cartRepo.save(cart);
	}

	public Optional<Cart> findCartById(long cartId) {
		logger.info("placing the Order and saving in DB");
		return cartRepo.findById(cartId);
	}

	public List<Cart> findProductsByUserId(long userId) {
		return cartRepo.findProductsByUserId(userId);
	}
}
