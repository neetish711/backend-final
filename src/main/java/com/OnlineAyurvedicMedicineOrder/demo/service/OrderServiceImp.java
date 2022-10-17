package com.OnlineAyurvedicMedicineOrder.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnlineAyurvedicMedicineOrder.demo.entity.Order;
import com.OnlineAyurvedicMedicineOrder.demo.exception.OrderAlreadyExistsException;
import com.OnlineAyurvedicMedicineOrder.demo.exception.OrderDoesNotExistsException;
import com.OnlineAyurvedicMedicineOrder.demo.repository.OrderRepository;

@Service
public class OrderServiceImp implements OrderService {

	@Autowired
	private OrderRepository orderRepo;

	@Override
	public Order addOrder(Order order) throws OrderAlreadyExistsException {
		if (orderRepo.existsById(order.getOrderId()))
			throw new OrderAlreadyExistsException();
		Order savedOrder = orderRepo.save(order);
		return savedOrder;
	}

	@Override
	public Order viewOrder(int id) throws OrderDoesNotExistsException {
		if (!orderRepo.existsById(id))
			throw new OrderDoesNotExistsException();
		Optional<Order> order = orderRepo.findById(id);
		return order.get();
	}

	@Override
	public Order updateOrder(Order order) {
		Order savedOrder = orderRepo.save(order);
		return savedOrder;
	}

	@Override
	public Order cancelOrder(int id) throws OrderDoesNotExistsException {
		if (!orderRepo.existsById(id))
			throw new OrderDoesNotExistsException();
		Optional<Order> order = orderRepo.findById(id);
		orderRepo.deleteById(id);
		return order.get();
	}

	public List<Order> showAllOrders() {
		List<Order> orders = orderRepo.findAll();
		return orders;
	}

}
