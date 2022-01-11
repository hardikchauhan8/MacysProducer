package com.macys.macysordermessageproducer.dto.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.io.Serializable;

public class BillingAddress implements Serializable {

    @JacksonXmlProperty(localName = "contact")
    private Contact contact;

    public BillingAddress() {

    }

    public BillingAddress(Contact contact) {
        this.contact = contact;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "BillingAddress{" +
                "contact=" + contact +
                '}';
    }
}