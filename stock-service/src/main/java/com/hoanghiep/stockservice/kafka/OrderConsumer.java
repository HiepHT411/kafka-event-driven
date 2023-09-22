package com.hoanghiep.stockservice.kafka;

import com.hoanghiep.basedomain.entity.OrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderConsumer {

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderEvent eventMessage) {

        log.info(String.format("Order event received in stock service -> %s", eventMessage.toString()));


    }
}
