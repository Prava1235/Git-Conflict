package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.demo.audit.Auditable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Data
@Getter
@Setter
@Entity
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Cart extends Auditable<String>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cartId;
	@NotNull
	private long productId;
	@NotNull
	private long userId;
	@NotNull
	private int totalPrice;
	@NotNull
	private String status;
    @NotNull
	private int quantity;
    
	
	
}
