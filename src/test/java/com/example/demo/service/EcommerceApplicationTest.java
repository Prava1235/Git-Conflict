package com.example.demo.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

import com.example.demo.entity.Cart;
import com.example.demo.repostiory.CartRepository;

@RunWith(PowerMockRunner.class)
public class EcommerceApplicationTest {

	@Mock
	Cart cart;
	@InjectMocks
	CartService cartService;
	@Mock
	CartRepository cartRepository;
	
	@Test
	public void testCartData() {

		//Cart cart = new Cart();
		List<Cart> cartList  = new ArrayList<Cart>();
		cart.setCartId(1);
		cart.setProductId(1);
		cart.setUserId(1);
		cartList.add(cart);
		PowerMockito.when(cartService.findProductsByUserId(cart.getUserId())).thenReturn(cartList);
		assertEquals(1, cartList.size());
	}


}
