package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SearchProductInformation {
	private String productName;
	private String productDescription;
	private String availability;
	private String productCode;

}
