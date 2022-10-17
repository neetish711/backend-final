package com.OnlineAyurvedicMedicineOrder.demo.service;

import java.util.List;

import com.OnlineAyurvedicMedicineOrder.demo.entity.Order;
import com.OnlineAyurvedicMedicineOrder.demo.exception.OrderAlreadyExistsException;
import com.OnlineAyurvedicMedicineOrder.demo.exception.OrderDoesNotExistsException;

public interface OrderService {
	Order addOrder(Order order) throws OrderAlreadyExistsException;

	Order viewOrder(int id) throws OrderDoesNotExistsException;

	Order cancelOrder(int id) throws OrderDoesNotExistsException;

	List<Order> showAllOrders();

	Order updateOrder(Order order);
}
