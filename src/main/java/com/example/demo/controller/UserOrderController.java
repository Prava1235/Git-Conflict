package com.example.demo.controller;


import java.util.List;
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
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.UserOrder;
import com.example.demo.model.UserOrderDetailModel;
import com.example.demo.model.UserOrderModel;
import com.example.demo.service.UserOrderService;


@RestController
public class UserOrderController {
	private final  Logger LOG = LoggerFactory.getLogger(UserOrderController.class);

	@Autowired
	private UserOrderService userOrderService;
	
	
	
		

	@PostMapping("/userorderplaced")
	public ResponseEntity<Long> placeOrder(@RequestBody UserOrderModel userOrderModel) {
	Long  orderId = userOrderService.setOrder(userOrderModel);
	LOG.info("This is Placing Order Opration");
			return new ResponseEntity<>(orderId, new HttpHeaders(), HttpStatus.OK);
		}
	
	
	
	@GetMapping("/orderhistory/{days}/{userid}")
	public ResponseEntity<List<UserOrderDetailModel>> getOrderHistory(@PathVariable long userid,@PathVariable int days) {
		
		List<UserOrderDetailModel>  list = userOrderService.getOrderHistory(userid,days);
		
		return new ResponseEntity<List<UserOrderDetailModel>>(list, new HttpHeaders(), HttpStatus.OK);
		}
	
	/*@PostMapping("/changeorderstatus/{orderid}/{status}")
	public ResponseEntity<UserOrder> changeOrderStatus(@PathVariable long orderid,@PathVariable String status) {
		UserOrder  orderId = userOrderService.setOrderStatus(orderid,status);
		
			return new ResponseEntity<UserOrder>(orderId, new HttpHeaders(), HttpStatus.OK);
		}*/
	
	
	
	}
	



