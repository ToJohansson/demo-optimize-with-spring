package com.tobiasjohansson.demooptimize.services;

import com.tobiasjohansson.demooptimize.models.Order;
import com.tobiasjohansson.demooptimize.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public OrderService() {
    }

    // GET
    @Cacheable(value = "orders")
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }
    public Optional<Order> findOrderById(long id){
        return orderRepository.findById(id);
    }
    // SAVE
    @CachePut(value = "create_order")
    public Order saveOrder(Order order){

        return orderRepository.save(order);
    }
}
