package com.macys.macysordermessageproducer.controller;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.macys.macysordermessageproducer.dto.json.OrderMessageJson;
import com.macys.macysordermessageproducer.dto.xml.FulfillmentOrder;
import com.macys.macysordermessageproducer.service.MOMessageProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Boolean> produceXmlMessage(@RequestBody FulfillmentOrder fulfillmentOrder) {
        return messageService.produceXmlMessage(fulfillmentOrder);
    }

    @PostMapping(value = "/json",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Boolean> produceJsonMessage(@RequestBody OrderMessageJson orderMessageJson) {
        return messageService.produceJsonMessage(orderMessageJson);
    }

    void getLocalXml() {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream soapXML = classLoader.getResourceAsStream("static/test.xml");
        XMLInputFactory f = XMLInputFactory.newFactory();
        XMLStreamReader sr = null;
        try {
            sr = f.createXMLStreamReader(soapXML);
            XmlMapper mapper = new XmlMapper();
            FulfillmentOrder fulfillmentOrder = mapper.readValue(sr, FulfillmentOrder.class);

        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }
    }
}
