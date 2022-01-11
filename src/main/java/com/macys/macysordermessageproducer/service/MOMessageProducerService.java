package com.macys.macysordermessageproducer.service;

import com.macys.macysordermessageproducer.dto.json.OrderMessageJson;
import com.macys.macysordermessageproducer.dto.xml.FulfillmentOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

public interface MOMessageProducerService {
    ResponseEntity<Boolean> produceXmlMessage(FulfillmentOrder fulfillmentOrder);

    ResponseEntity<Boolean> produceJsonMessage(OrderMessageJson orderMessageJson);
}
