package com.macys.macysordermessageproducer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.api.core.ApiFuture;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.TopicName;
import com.macys.macysordermessageproducer.component.QueueSender;
import com.macys.macysordermessageproducer.dto.json.OrderMessageJson;
import com.macys.macysordermessageproducer.dto.xml.FulfillmentOrder;
import com.macys.macysordermessageproducer.util.GCPConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Service
public class MOMessageProducerServiceImpl implements MOMessageProducerService {

    @Autowired
    QueueSender queueSender;

    @Autowired
    private PubSubTemplate pubSubTemplate;

    @Value("${spring.cloud.gcp.project-id}")
    String projectId;

    @Override
    public ResponseEntity<Boolean> produceXmlMessageRabbitmq(FulfillmentOrder fulfillmentOrder) {
        try {
            queueSender.send(fulfillmentOrder);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Boolean> produceJsonMessageRabbitmq(OrderMessageJson orderMessageJson) {
        try {
            queueSender.send(orderMessageJson);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Boolean> produceXmlMessageGCP(FulfillmentOrder fulfillmentOrder) {
        try {
            publishWithCustomAttributes(new XmlMapper().writeValueAsString(fulfillmentOrder), "xml");
            return new ResponseEntity<>(true, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Boolean> produceJsonMessageGCP(OrderMessageJson orderMessageJson) {
        try {
            publishWithCustomAttributes(new ObjectMapper().writeValueAsString(orderMessageJson), "json");
            return new ResponseEntity<>(true, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void publishWithCustomAttributes(String message, String contentType)
            throws IOException, ExecutionException, InterruptedException {
        TopicName topicName = TopicName.of(projectId, GCPConstants.GCP_TOPIC);
        Publisher publisher = null;

        try {
            // Create a publisher instance with default settings bound to the topic
            publisher = Publisher.newBuilder(topicName).build();

            ByteString data = ByteString.copyFromUtf8(message);
            PubsubMessage pubsubMessage =
                    PubsubMessage.newBuilder()
                            .setData(data)
                            .putAllAttributes(ImmutableMap.of("contentType", contentType))
                            .build();

            // Once published, returns a server-assigned message id (unique within the topic)
            ApiFuture<String> messageIdFuture = publisher.publish(pubsubMessage);
            String messageId = messageIdFuture.get();
            System.out.println("Published a message with custom attributes: " + messageId);

        } finally {
            if (publisher != null) {
                // When finished with the publisher, shutdown to free up resources.
                publisher.shutdown();
                publisher.awaitTermination(1, TimeUnit.MINUTES);
            }
        }
    }
}
