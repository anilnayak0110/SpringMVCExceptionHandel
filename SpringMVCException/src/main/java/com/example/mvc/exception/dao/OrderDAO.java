package com.example.mvc.exception.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mvc.exception.model.Order;

public interface OrderDAO extends JpaRepository<Order, Integer>{

	Order findByName(String orderName);

}
