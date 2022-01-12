package com.macys.macysordermessageproducer.component;

import com.macys.macysordermessageproducer.util.GCPConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.stereotype.Component;

@Component
public class GcpSender {

    @Autowired
    private PubSubTemplate pubSubTemplate;

    public void publishXml(String fulfillmentOrder) {
        pubSubTemplate.publish(GCPConstants.GCP_XML_TOPIC, fulfillmentOrder);
    }

    public void publishJson(String orderMessageJson) {
        pubSubTemplate.publish(GCPConstants.GCP_JSON_TOPIC, orderMessageJson);
    }
}