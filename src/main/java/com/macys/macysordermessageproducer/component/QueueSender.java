package com.macys.macysordermessageproducer.component;

import com.macys.macysordermessageproducer.dto.json.OrderMessageJson;
import com.macys.macysordermessageproducer.dto.xml.FulfillmentOrder;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueueSender {

    @Autowired
    AmqpTemplate xmlAmqpTemplate;

    @Autowired
    AmqpTemplate jsonAmqpTemplate;

    @Autowired
    private Queue jsonQueue;

    @Autowired
    private Queue xmlQueue;

    public void send(FulfillmentOrder fulfillmentOrder) throws AmqpException {
        xmlAmqpTemplate.convertAndSend(xmlQueue.getName(), fulfillmentOrder);
    }

    public void send(OrderMessageJson orderMessageJson) throws AmqpException {
        jsonAmqpTemplate.convertAndSend(jsonQueue.getName(), orderMessageJson);
    }
}