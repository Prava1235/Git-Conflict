package com.example.demo.repostiory;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UserCartDetail;
import com.example.demo.entity.UserCartDetailPk;


public interface UserOrderDetailRepository extends JpaRepository<UserCartDetail, UserCartDetailPk> {

	
	
	
}