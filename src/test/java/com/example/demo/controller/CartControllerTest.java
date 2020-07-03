package com.example.demo.controller;


import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.ResponseEntity;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.feignclient.ProductClient;
import com.example.demo.service.CartService;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CartControllerTest {

	@Mock
	UserService userService;
	@Mock
	CartService cartService;
	@Mock
	ProductClient productClient;
	@Mock
	ProductService productService;
	@InjectMocks
	CartController cartController;
	
	@Test
	public void testAddToCartWhenNotFound() throws Exception {
		Cart cart = new Cart();
		cart.setCartId(1);
		cart.setProductId(1);
		cart.setUserId(1);
		User user = new User();
		user.setId(1);
		List<Cart> cartList  = new ArrayList<Cart>();
		cartList.add(cart);
		Mockito.when(cartService.findProductsByUserId(cart.getUserId())).thenReturn(cartList);
		Mockito.when(userService.findUser(cart.getUserId())).thenReturn(Optional.of(user));
		ResponseEntity<String> entity = cartController.addToCart(cart);
		assertEquals(200, entity.getStatusCodeValue());
		
	}
	
	@Test
	public void testAddToCartWhenAvailable() throws Exception {
		Cart cart = new Cart();
		cart.setCartId(1);
		cart.setProductId(1);
		cart.setUserId(1);
		cart.setQuantity(1);
		User user = new User();
		user.setId(1);
		List<Cart> cartList  = new ArrayList<Cart>();
		cartList.add(cart);
		Product product = new Product();
		product.setName("Apple");
		product.setId(1);
		product.setPrice(new BigDecimal(22));
		product.setAvailability(true);
		Mockito.when(cartService.findProductsByUserId(cart.getUserId())).thenReturn(cartList);
		Mockito.when(userService.findUser(cart.getUserId())).thenReturn(Optional.of(user));
		Mockito.when(productClient.getProduct(cart.getProductId())).thenReturn(Optional.of(product));
		ResponseEntity<String> entity = cartController.addToCart(cart);
		assertEquals("Added", cart.getStatus());
	}
	
}
