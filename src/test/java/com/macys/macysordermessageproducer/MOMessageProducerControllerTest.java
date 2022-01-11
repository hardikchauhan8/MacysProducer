package com.macys.macysordermessageproducer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.macys.macysordermessageproducer.component.QueueSender;
import com.macys.macysordermessageproducer.controller.MOMessageProducerController;
import com.macys.macysordermessageproducer.dto.json.OrderMessageJson;
import com.macys.macysordermessageproducer.dto.xml.FulfillmentOrder;
import com.macys.macysordermessageproducer.service.MOMessageProducerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class MOMessageProducerControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    MOMessageProducerService service;

    @Autowired
    MOMessageProducerController controller;

    @Test
    void testContollerNotNull() {
        Assertions.assertNotNull(controller);
    }

    @Test
    void testServiceProduceXmlMessage() throws Exception {
        FulfillmentOrder fulfillmentOrder = new FulfillmentOrder();
        given(service.produceXmlMessageRabbitmq(fulfillmentOrder)).willReturn(new ResponseEntity<>(true, HttpStatus.OK));

        XmlMapper xmlMapper = new XmlMapper();
        String xmlString = xmlMapper.writeValueAsString(fulfillmentOrder);

        mvc.perform(post("/macy/producer/xml")
                        .content(xmlString)
                        .contentType(MediaType.APPLICATION_XML_VALUE))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void testServiceProduceXJsonMessage() throws Exception {
        OrderMessageJson orderMessageJson = new OrderMessageJson();
        given(service.produceJsonMessageRabbitmq(orderMessageJson)).willReturn(new ResponseEntity<>(true, HttpStatus.OK));

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(orderMessageJson);

        mvc.perform(post("/macy/producer/json")
                        .content(jsonString)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andDo(print());
    }

}
