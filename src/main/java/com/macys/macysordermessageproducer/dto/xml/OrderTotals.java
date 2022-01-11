package com.macys.macysordermessageproducer.dto.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.io.Serializable;

public class OrderTotals implements Serializable {

    @JacksonXmlProperty(localName = "totalPurchaseAmount")
    private double totalPurchaseAmount;

    @JacksonXmlProperty(localName = "seperatorOrderTotals0")
    private int separatorOrderTotals0;

    public OrderTotals() {
    }

    public OrderTotals(double totalPurchaseAmount, int separatorOrderTotals0) {
        this.totalPurchaseAmount = totalPurchaseAmount;
        this.separatorOrderTotals0 = separatorOrderTotals0;
    }

    public double getTotalPurchaseAmount() {
        return totalPurchaseAmount;
    }

    public void setTotalPurchaseAmount(double totalPurchaseAmount) {
        this.totalPurchaseAmount = totalPurchaseAmount;
    }

    public int getSeparatorOrderTotals0() {
        return separatorOrderTotals0;
    }

    public void setSeparatorOrderTotals0(int separatorOrderTotals0) {
        this.separatorOrderTotals0 = separatorOrderTotals0;
    }

    @Override
    public String toString() {
        return "OrderTotals{" +
                "totalPurchaseAmount=" + totalPurchaseAmount +
                ", separatorOrderTotals0=" + separatorOrderTotals0 +
                '}';
    }
}