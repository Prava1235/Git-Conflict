package com.example.demo.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface UserRepository extends  JpaRepository<User, Long>{
	public User findByName(String UserName);

}
