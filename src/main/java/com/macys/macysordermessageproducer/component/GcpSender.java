package com.macys.macysordermessageproducer.component;

import com.macys.macysordermessageproducer.dto.json.OrderMessageJson;
import com.macys.macysordermessageproducer.dto.xml.FulfillmentOrder;
import com.macys.macysordermessageproducer.util.GCPConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.stereotype.Component;

@Component
public class GcpSender {

    @Autowired
    private PubSubTemplate pubSubTemplate;

    public void publishXml(FulfillmentOrder fulfillmentOrder) {
        pubSubTemplate.publish(GCPConstants.GCP_XML_TOPIC, fulfillmentOrder);
    }

    public void publishJson(OrderMessageJson orderMessageJson) {
        pubSubTemplate.publish(GCPConstants.GCP_JSON_TOPIC, orderMessageJson);
    }
}