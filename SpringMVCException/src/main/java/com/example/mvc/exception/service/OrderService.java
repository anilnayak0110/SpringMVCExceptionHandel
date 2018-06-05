package com.example.mvc.exception.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mvc.exception.OrderException;
import com.example.mvc.exception.dao.OrderDAO;
import com.example.mvc.exception.model.Order;

@Service
public class OrderService {
	@Autowired
	private OrderDAO dao;

	@PostConstruct
	public void addOrder2DB() {
		List<Order> orderList = new ArrayList<Order>();
		orderList.add(new Order(1, "MI", "Mobile", 30000.00));
		orderList.add(new Order(2, "1+", "Mobile", 40000.00));
		orderList.add(new Order(3, "Moto", "Mobile", 20000.00));
		orderList.add(new Order(4, "IPhone", "Mobile", 50000.00));
		dao.saveAll(orderList);
	}

	public double getOrderPriceByName(String orderName) throws OrderException {
		Order order = null;
		double amount = 0.0;
		try {
			order = dao.findByName(orderName);
			amount = order.getAmount();

		} catch (Exception e) {
			 throw new OrderException("Order not found with this order name :"+orderName);
		}

		return amount;
	}

}
