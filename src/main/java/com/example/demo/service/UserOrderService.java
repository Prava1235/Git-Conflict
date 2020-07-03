package com.example.demo.service;


import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.exception.OrderNotFoundException;
import com.example.demo.model.OrderDetailModel;
import com.example.demo.entity.UserCartDetail;
import com.example.demo.entity.UserOrder;
import com.example.demo.model.UserOrderDetailModel;
import com.example.demo.model.UserOrderModel;
import com.example.demo.repostiory.UserCartOrderDetailRepository;
import com.example.demo.repostiory.UserOrderRepository;

@Service
public class UserOrderService {
	private final Logger LOG = LoggerFactory.getLogger(UserOrderService.class);

	@Autowired
	private UserOrderRepository userOrderRepository;
	
	@Autowired
	private UserCartOrderDetailRepository userCartOrderRepository;

	public List<UserOrderDetailModel> getOrderHistory(long uid, int days ) {
		
		List<UserOrderDetailModel>  userOrderDetailList = new ArrayList<UserOrderDetailModel> ();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -(days));
		java.util.Date pastDate = cal.getTime();
		
		DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		
		
		List<UserOrder> userOrderList = userOrderRepository.findOrderHistory(uid, pastDate);
		for(UserOrder userOder: userOrderList) {
			UserOrderDetailModel userOrderDetail = new UserOrderDetailModel();
			userOrderDetail.setUserId(userOder.getUserId());
			java.util.Date orderDate = new java.util.Date(userOder.getOrderDate().getTime());
			String weekendDateStr = dateformat.format(orderDate);
			userOrderDetail.setOrderDate(weekendDateStr);
			userOrderDetail.setOrderId(userOder.getOrderId());
			userOrderDetail.setOrderStatus(userOder.getOrderStatus());
			List<UserCartDetail> userCartDetailList = userCartOrderRepository.findOrderHistory(userOder.getUserCartId());
			List<OrderDetailModel> orderDetailModelList = new ArrayList<OrderDetailModel>();
			for(UserCartDetail userCartDEtail: userCartDetailList) {
				OrderDetailModel orderDetailModel = new OrderDetailModel();
				orderDetailModel.setProductid(userCartDEtail.getUserOrderDetailPk().getProductId());
				orderDetailModel.setPrice(userCartDEtail.getPrice());
				orderDetailModel.setQuantity(userCartDEtail.getQuantity());
				orderDetailModelList.add(orderDetailModel);
			}
			userOrderDetail.setOrderDetailModelList(orderDetailModelList);
			userOrderDetailList.add(userOrderDetail);	
		}
		
		return userOrderDetailList;
		
	}
	
	public UserOrder setOrderStatus(long orderid, String status) {
		
		UserOrder userorderupd = null;
	     
	     Optional<UserOrder> userOrder =  userOrderRepository.findById(orderid);
	     if(userOrder.isPresent()) {
	    	 UserOrder temp = userOrder.get();
	    	 temp.setOrderStatus(status);
	    	 userorderupd =  userOrderRepository.save(temp);
	     }
	     else {
	    	 
	    	 throw new OrderNotFoundException("Order Not Found.  :: " + orderid);
	     }
	    	 
		    		  
	    return userorderupd;
	}

	

	public long setOrder(UserOrderModel userOrderModel) {
		
		
		UserOrder userOrder =new UserOrder();
		
		      userOrder.setUserId(userOrderModel.getUserId());
		      userOrder.setUserCartId(userOrderModel.getUserCartId());
		      Date date=new Date(System.currentTimeMillis());
		      userOrder.setOrderDate(date);
		      userOrder.setOrderStatus(userOrderModel.getStatus());
		      
		      UserOrder userOrderret =   userOrderRepository.save(userOrder);
		      if (userOrderret!=null) {
		    	  LOG.info("Order: {} has been successfully placed. ", userOrderModel.getUserId());
		    	  return userOrderret.getOrderId();  
		    	  
		      }
		      else
		      {
		    	  return 0;
		      }
		
	}

}
