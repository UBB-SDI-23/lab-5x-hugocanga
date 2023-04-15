package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.Exceptions.OrderNotFoundException;
import main.domain.Order;
import main.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order newOrder) {
        Order existingOrder = getOrderById(id);
        existingOrder.setOrderDate(newOrder.getOrderDate());
        existingOrder.setStatus(newOrder.getStatus());
        existingOrder.setTotalPrice(newOrder.getTotalPrice());
        existingOrder.setQuantity(newOrder.getQuantity());
        existingOrder.setCustomer(newOrder.getCustomer());
        return orderRepository.save(existingOrder);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public List<Order> getOrdersByTotalPriceGreaterThan(double price) {
        return orderRepository.findByTotalPriceGreaterThan(price);
    }

}

