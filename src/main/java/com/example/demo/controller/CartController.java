package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
//comment by Prabir
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.feignclient.ProductClient;
import com.example.demo.service.CartService;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;

import io.swagger.annotations.ApiOperation;

/**
 * @author anupesh.p
 *
 */
@RestController
@ApiOperation("Cart Controller")
@RequestMapping("/carts")
public class CartController {

	@Autowired
	UserService userService;
	@Autowired
	CartService cartService;

	@Autowired
	ProductClient productClient;
	
	@Autowired
	ProductService productService;

	private static final Logger logger = LoggerFactory.getLogger(CartController.class);

	/**
	 * @param cart
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "Adding Product to cart")
	@PostMapping("")
	public ResponseEntity<String> addToCart(@Valid @RequestBody Cart cart) throws Exception {

		logger.info("Adding the product in cart" + productClient.getProduct(cart.getProductId()));
		Optional<Product> product = productClient.getProduct(cart.getProductId());
		
		User user = userService.findUser(cart.getUserId()).get();
		if (product.isPresent() && product.get().isAvailability()
				&& userService.findUser(cart.getUserId()).isPresent()) {
			cart.setStatus("Added");
			cart.setTotalPrice(product.get().getPrice().intValue() * cart.getQuantity());
			cart.setLastModifiedBy(user.getName());
			cart.setCreatedBy(user.getName());
			cartService.save(cart);
			logger.info("Added");
			return ResponseEntity.status(HttpStatus.OK).body("product is added to cart " + cart.getProductId());
		} else {
			return ResponseEntity.status(HttpStatus.OK)
					.body(!product.isPresent() ? "product is out of stock or not available, please try again later "
							: "User is not registered ");
		}

	}
	
	/**
	 * @param userId
	 * @return
	 */
	@ApiOperation(value = "Lists All Products based on user")
	@GetMapping("/{userId}")
	public ResponseEntity<List<Product>> listProductsByUserIds(@PathVariable long userId) {
		logger.info("listProductsByUserIds");
		List<Cart> carts = cartService.findProductsByUserId(userId);
		List<Long> temp = new ArrayList<Long>();
		 List<Product> prodList = null;
		carts.forEach(cart -> {
			if(!Objects.isNull(cart.getProductId())) {
				temp.add(cart.getProductId());
			}
			
				
		});
		logger.info("=================" + temp);
		prodList =productService.findProductsByUserId(temp);
		return new ResponseEntity<List<Product>>(prodList, new HttpHeaders(),
				HttpStatus.OK);
	}
	
}
