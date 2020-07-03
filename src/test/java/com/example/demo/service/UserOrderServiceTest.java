package com.example.demo.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.demo.model.OrderDetailModel;
import com.example.demo.entity.UserCartDetail;
import com.example.demo.entity.UserCartDetailPk;
import com.example.demo.entity.UserOrder;
import com.example.demo.model.UserOrderDetailModel;
import com.example.demo.model.UserOrderModel;
import com.example.demo.repostiory.UserCartOrderDetailRepository;
import com.example.demo.repostiory.UserOrderRepository;

public class UserOrderServiceTest {

	@InjectMocks
	UserOrderService userOrderService;

	@Mock
	UserCartOrderDetailRepository userCartOrderRepository;
	@Mock
	UserOrderRepository userOrderRepository;
	
	

	@Before
	public void init() {

		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void setOrder1() {
		UserOrderModel userOrderModel = new UserOrderModel();
		userOrderModel.setUserId(1);
		userOrderModel.setUserCartId(1);
		userOrderModel.setStatus("cancelled");
		UserOrder userOrder = new UserOrder();

		userOrder.setUserId(userOrderModel.getUserId());
		userOrder.setUserCartId(userOrderModel.getUserCartId());
		Date date = new Date(System.currentTimeMillis());
		userOrder.setOrderDate(date);
		userOrder.setOrderStatus(userOrderModel.getStatus());
		userOrder.setOrderId(13);
		
		UserOrder userOrderrr = new UserOrder();
        
		when(userOrderRepository.save(userOrderrr)).thenReturn(userOrder);
			
		long ordid = userOrderService.setOrder(userOrderModel);
		assertEquals(0, ordid);

	}
	
	@Test
	public void setOrder2() {
		UserOrderModel userOrderModel = new UserOrderModel();
		userOrderModel.setUserId(1);
		userOrderModel.setUserCartId(1);
		userOrderModel.setStatus("cancelled");
		UserOrder userOrder = new UserOrder();

		userOrder.setUserId(userOrderModel.getUserId());
		userOrder.setUserCartId(userOrderModel.getUserCartId());
		Date date = new Date(System.currentTimeMillis());
		userOrder.setOrderDate(date);
		userOrder.setOrderStatus(userOrderModel.getStatus());
		userOrder.setOrderId(13);
		
		
        
		when(userOrderRepository.save(Mockito.any(UserOrder.class))).thenReturn(userOrder);
			
		long ordid = userOrderService.setOrder(userOrderModel);
		assertEquals(13, ordid);

	}


//	@Test
//	public void getOrderHistory() {
//
//		userOrderService.getOrderHistory(1, 7);
//
//		assertTrue(true);
//
//	}
	
//	@Test
//	public void getOrderHistory() {
//		
//		List<UserOrder> userOrderList = new ArrayList<UserOrder>();
//		UserOrder userOrder = new UserOrder();
//		userOrder.setUserId(1);
//		userOrder.setUserCartId(2);
//		Date date = new Date(System.currentTimeMillis());
//		userOrder.setOrderDate(date);
//		userOrder.setOrderStatus("Cancelled");
//		userOrder.setOrderId(13);
//		userOrderList.add(userOrder);
//		
//		List<UserCartDetail> userCartDetailList = new ArrayList<UserCartDetail>();
//		UserCartDetail userCartDetail = new UserCartDetail();
//		UserCartDetailPk userCartDetailPk = new UserCartDetailPk();
//		userCartDetailPk.setProductId(1);
//		userCartDetailPk.setUserCartId(1);
//		userCartDetailPk.getProductId();
//		userCartDetailPk.getUserCartId();
//		int abc = userCartDetailPk.hashCode();
//		boolean isTrue = userCartDetailPk.equals(userOrder);
//		if(!isTrue) {
//			OrderDetailModel orderModelModel = new OrderDetailModel(1,5,50.00);
//			orderModelModel.getPrice();
//			orderModelModel.getProductid();
//			orderModelModel.getQuantity();
//			UserOrderDetailModel userOrderDetailModel = new UserOrderDetailModel();
//			userOrderDetailModel.getOrderDate();
//			userOrderDetailModel.getOrderId();
//			userOrderDetailModel.getOrderStatus();
//			userOrderDetailModel.getOrderDetailModelList();
//			userOrderDetailModel.getUserId();
//		}
//		isTrue = userCartDetailPk.equals(null);
//		isTrue = userCartDetailPk.equals(userCartDetailPk);
//		userCartDetail.setUserOrderDetailPk(userCartDetailPk);
//		userCartDetail.setQuantity(6);
//		userCartDetail.setPrice(600.00);
//		userCartDetailList.add(userCartDetail);
//		when(userOrderRepository.findOrderHistory(Mockito.anyLong(),Mockito.any(java.util.Date.class))).thenReturn(userOrderList);
//		when(userCartOrderRepository.findOrderHistory(Mockito.anyLong())).thenReturn(userCartDetailList);
//
//		userOrderService.getOrderHistory(1, 7);
//
//		assertTrue(true);
//
//	}

}
