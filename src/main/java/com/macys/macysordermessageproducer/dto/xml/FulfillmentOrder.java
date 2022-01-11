package com.macys.macysordermessageproducer.dto.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.macys.macysordermessageproducer.dto.OrderStatus;

import java.io.Serializable;

@JacksonXmlRootElement(namespace = "ns0:http://www.mst.macys.com/main/eos/fulfillmentOrder/orderDetails.v1.1")
public class FulfillmentOrder implements Serializable {

    @JacksonXmlProperty(localName = "orderID")
    private int orderID;

    @JacksonXmlProperty(localName = "orderTypeCode")
    private String orderTypeCode;

    @JacksonXmlProperty(localName = "partnerOrderID")
    private String partnerOrderID;

    @JacksonXmlProperty(localName = "orderStatus")
    private OrderStatus orderStatus = OrderStatus.CREATED;

    @JacksonXmlProperty(localName = "messageCreateTimeStamp")
    private String messageCreateTimeStamp;

    @JacksonXmlProperty(localName = "fulfillmentChannelCode")
    private String fulfillmentChannelCode;

    @JacksonXmlProperty(localName = "orderStatusCode")
    private int orderStatusCode;

    @JacksonXmlProperty(localName = "orderStatusDescription")
    private String orderStatusDescription;

    @JacksonXmlProperty(localName = "sellZLDivisionNbr")
    private int sellZLDivisionNbr;

    @JacksonXmlProperty(localName = "sellZLLocationNbr")
    private int sellZLLocationNbr;

    @JacksonXmlProperty(localName = "source")
    private Source source;

    @JacksonXmlProperty(localName = "orderTotals")
    private OrderTotals orderTotals;

    @JacksonXmlProperty(localName = "billingAddress")
    private BillingAddress billingAddress;

    public FulfillmentOrder() {
    }

    public FulfillmentOrder(int orderID, String orderTypeCode, String partnerOrderID, OrderStatus orderStatus, String messageCreateTimeStamp, String fulfillmentChannelCode, int orderStatusCode, String orderStatusDescription, int sellZLDivisionNbr, int sellZLLocationNbr, Source source, OrderTotals orderTotals, BillingAddress billingAddress) {
        this.orderID = orderID;
        this.orderTypeCode = orderTypeCode;
        this.partnerOrderID = partnerOrderID;
        this.orderStatus = orderStatus;
        this.messageCreateTimeStamp = messageCreateTimeStamp;
        this.fulfillmentChannelCode = fulfillmentChannelCode;
        this.orderStatusCode = orderStatusCode;
        this.orderStatusDescription = orderStatusDescription;
        this.sellZLDivisionNbr = sellZLDivisionNbr;
        this.sellZLLocationNbr = sellZLLocationNbr;
        this.source = source;
        this.orderTotals = orderTotals;
        this.billingAddress = billingAddress;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getOrderTypeCode() {
        return orderTypeCode;
    }

    public void setOrderTypeCode(String orderTypeCode) {
        this.orderTypeCode = orderTypeCode;
    }

    public String getPartnerOrderID() {
        return partnerOrderID;
    }

    public void setPartnerOrderID(String partnerOrderID) {
        this.partnerOrderID = partnerOrderID;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getMessageCreateTimeStamp() {
        return messageCreateTimeStamp;
    }

    public void setMessageCreateTimeStamp(String messageCreateTimeStamp) {
        this.messageCreateTimeStamp = messageCreateTimeStamp;
    }

    public String getFulfillmentChannelCode() {
        return fulfillmentChannelCode;
    }

    public void setFulfillmentChannelCode(String fulfillmentChannelCode) {
        this.fulfillmentChannelCode = fulfillmentChannelCode;
    }

    public int getOrderStatusCode() {
        return orderStatusCode;
    }

    public void setOrderStatusCode(int orderStatusCode) {
        this.orderStatusCode = orderStatusCode;
    }

    public String getOrderStatusDescription() {
        return orderStatusDescription;
    }

    public void setOrderStatusDescription(String orderStatusDescription) {
        this.orderStatusDescription = orderStatusDescription;
    }

    public int getSellZLDivisionNbr() {
        return sellZLDivisionNbr;
    }

    public void setSellZLDivisionNbr(int sellZLDivisionNbr) {
        this.sellZLDivisionNbr = sellZLDivisionNbr;
    }

    public int getSellZLLocationNbr() {
        return sellZLLocationNbr;
    }

    public void setSellZLLocationNbr(int sellZLLocationNbr) {
        this.sellZLLocationNbr = sellZLLocationNbr;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public OrderTotals getOrderTotals() {
        return orderTotals;
    }

    public void setOrderTotals(OrderTotals orderTotals) {
        this.orderTotals = orderTotals;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    @Override
    public String toString() {
        return "FulfillmentOrder{" +
                "orderID=" + orderID +
                ", orderTypeCode='" + orderTypeCode + '\'' +
                ", partnerOrderID='" + partnerOrderID + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", messageCreateTimeStamp='" + messageCreateTimeStamp + '\'' +
                ", fulfillmentChannelCode='" + fulfillmentChannelCode + '\'' +
                ", orderStatusCode=" + orderStatusCode +
                ", orderStatusDescription='" + orderStatusDescription + '\'' +
                ", sellZLDivisionNbr=" + sellZLDivisionNbr +
                ", sellZLLocationNbr=" + sellZLLocationNbr +
                ", source=" + source +
                ", orderTotals=" + orderTotals +
                ", billingAddress=" + billingAddress +
                '}';
    }
}