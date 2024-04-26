package com.tobiasjohansson.demooptimize.controllers;

import com.tobiasjohansson.demooptimize.models.Order;
import com.tobiasjohansson.demooptimize.repositories.OrderRepository;
import com.tobiasjohansson.demooptimize.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderRepository orderRepository;

    public OrderController() {
    }

    //GET
    @GetMapping("/allorders")
    public List<Order> getAllOrder(){
        return orderService.getAllOrders();
    }

    @GetMapping("/findbyid/{id}")
    public Optional<Order> findOrderById(@PathVariable("id") long id){
        return orderService.findOrderById(id);
    }

    @GetMapping("getallwithpage")
    public ResponseEntity<Page<Order>> getAllWithPage( Pageable pageable){
        return new ResponseEntity<>(orderRepository.findAll(pageable), HttpStatus.OK);
    }

    // SAVE
    @PostMapping("/postorder")
    public ResponseEntity<Order> postOrder(@RequestBody Order order){
        return new ResponseEntity<Order>(orderService.saveOrder(order), HttpStatus.CREATED);
    }
}
