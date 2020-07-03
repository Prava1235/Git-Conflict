package com.example.demo.repostiory;



import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.UserCartDetail;
import com.example.demo.entity.UserCartDetailPk;



public interface UserCartOrderDetailRepository extends JpaRepository<UserCartDetail, UserCartDetailPk> {

	@Query("select scx from UserCartDetail scx where scx.userOrderDetailPk.userCartId = ?1")	
	List<UserCartDetail>  findOrderHistory(Long id);
}
