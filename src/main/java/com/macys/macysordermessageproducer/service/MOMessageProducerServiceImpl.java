package com.macys.macysordermessageproducer.service;

import com.macys.macysordermessageproducer.component.QueueSender;
import com.macys.macysordermessageproducer.dto.json.OrderMessageJson;
import com.macys.macysordermessageproducer.dto.xml.FulfillmentOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MOMessageProducerServiceImpl implements MOMessageProducerService {

    @Autowired
    QueueSender queueSender;

    @Override
    public ResponseEntity<Boolean> produceXmlMessage(FulfillmentOrder fulfillmentOrder) {
        try {
            queueSender.send(fulfillmentOrder);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Boolean> produceJsonMessage(OrderMessageJson orderMessageJson) {
        try {
            queueSender.send(orderMessageJson);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
