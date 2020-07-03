package com.example.demo.repostiory;


import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.entity.UserOrder;


public interface UserOrderRepository extends JpaRepository<UserOrder, Long> {

	
	@Query("select scx from UserOrder scx where scx.userId = ?1 AND scx.orderDate > ?2 ")	
	List<UserOrder>  findOrderHistory(Long id,Date date);
	

}
