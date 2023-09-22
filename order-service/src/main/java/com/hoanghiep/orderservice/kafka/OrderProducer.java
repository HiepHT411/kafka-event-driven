package com.hoanghiep.orderservice.kafka;

import com.hoanghiep.basedomain.entity.OrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderProducer {

    private NewTopic topic;

    private KafkaTemplate<String, OrderEvent> kafkaTemplate;

//    private final String TOPIC = "wikimedia_recentchange";
    public OrderProducer(KafkaTemplate<String, OrderEvent> kafkaTemplate, NewTopic topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    public void sendMessage(OrderEvent event){

        log.info(String.format("Order event => %s", event.toString()));
        Message<OrderEvent> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();
        kafkaTemplate.send(message);
    }
}
