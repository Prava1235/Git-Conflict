package com.example.demo.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.example.demo.entity.Cart;
import com.example.demo.repostiory.CartRepository;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CartServiceTest {

	@InjectMocks
	CartService cartService;
	@Mock
	CartRepository cartRepository;
	
	@Test
	public void testCartData() {

		List<Cart> cartList  = new ArrayList<Cart>();
		Cart cart  = new Cart();
		cart.setCartId(1);
		cart.setProductId(1);
		cart.setUserId(1);
		cartList.add(cart);
		Mockito.when(cartService.findProductsByUserId(cart.getUserId())).thenReturn(cartList);
		assertEquals(1, cartList.size());
	}


}
