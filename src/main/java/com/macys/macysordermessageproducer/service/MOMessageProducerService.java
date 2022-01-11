package com.macys.macysordermessageproducer.service;

import com.macys.macysordermessageproducer.dto.json.OrderMessageJson;
import com.macys.macysordermessageproducer.dto.xml.FulfillmentOrder;
import org.springframework.http.ResponseEntity;

public interface MOMessageProducerService {
    ResponseEntity<Boolean> produceXmlMessageRabbitmq(FulfillmentOrder fulfillmentOrder);

    ResponseEntity<Boolean> produceJsonMessageRabbitmq(OrderMessageJson orderMessageJson);

    ResponseEntity<Boolean> produceXmlMessageGCP(FulfillmentOrder fulfillmentOrder);

    ResponseEntity<Boolean> produceJsonMessageGCP(OrderMessageJson orderMessageJson);
}
