package com.wipro.wipromart.model;


import java.time.LocalDate;
import java.util.List;

import com.wipro.wipromart.entity.OrderItem;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class OrderDto {

	private int orderId;
	private LocalDate orderDate;
	private double orderAmount;
	private String orderStatus;
	
	private List<OrderItem> orderItems;
}
