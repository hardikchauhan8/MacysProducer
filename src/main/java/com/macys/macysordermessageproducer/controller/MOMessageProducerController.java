package com.macys.macysordermessageproducer.controller;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.macys.macysordermessageproducer.dto.json.OrderMessageJson;
import com.macys.macysordermessageproducer.dto.xml.FulfillmentOrder;
import com.macys.macysordermessageproducer.service.MOMessageProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping(value = "/macy/producer")
public class MOMessageProducerController {

    @Autowired
    MOMessageProducerService messageService;

    @PostMapping(value = "/xml",
            consumes = {MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Boolean> produceXmlMessage(@RequestBody FulfillmentOrder fulfillmentOrder, @RequestHeader("x-messaging-queue") String queue) {
        if(queue.equalsIgnoreCase("gcp")){
            return messageService.produceXmlMessageGCP(fulfillmentOrder);
        } else {
            return messageService.produceXmlMessageRabbitmq(fulfillmentOrder);
        }
    }

    @PostMapping(value = "/json",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Boolean> produceJsonMessage(@RequestBody OrderMessageJson orderMessageJson, @RequestHeader("x-messaging-queue") String queue) {
        if(queue.equalsIgnoreCase("gcp")){
            return messageService.produceJsonMessageGCP(orderMessageJson);
        } else {
            return messageService.produceJsonMessageRabbitmq(orderMessageJson);
        }
    }
}
