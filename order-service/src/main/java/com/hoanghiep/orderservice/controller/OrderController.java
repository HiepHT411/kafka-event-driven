package com.hoanghiep.orderservice.controller;

import com.hoanghiep.basedomain.entity.Order;
import com.hoanghiep.basedomain.entity.OrderEvent;
import com.hoanghiep.orderservice.kafka.OrderProducer;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/order")
@AllArgsConstructor
public class OrderController {

    private OrderProducer orderProducer;

    @PostMapping()
    public String placeOrder(@RequestBody Order order) {
        order.setId(1l);
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setOrder(order);
        orderEvent.setStatus("PENDING");
        orderEvent.setMessage("Order status is in pending state");

        orderProducer.sendMessage(orderEvent);

        return "Order placed successfully!";
    }

}
