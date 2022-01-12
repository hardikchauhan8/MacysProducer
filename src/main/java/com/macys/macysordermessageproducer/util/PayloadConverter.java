package com.macys.macysordermessageproducer.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.macys.macysordermessageproducer.dto.json.OrderMessageJson;
import com.macys.macysordermessageproducer.dto.xml.FulfillmentOrder;

public class PayloadConverter {
    public static String convertXmlPayload(FulfillmentOrder fulfillmentOrder) throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();
        return mapper.writeValueAsString(fulfillmentOrder);
    }

    public static String convertJsonPayload(OrderMessageJson orderMessageJson) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(orderMessageJson);
    }
}
