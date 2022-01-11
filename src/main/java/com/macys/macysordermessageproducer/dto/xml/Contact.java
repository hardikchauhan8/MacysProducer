package com.macys.macysordermessageproducer.dto.xml;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.io.Serializable;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Contact implements Serializable {

    @JacksonXmlProperty(localName = "custID")
    private int custID;

    @JacksonXmlProperty(localName = "name")
    private Name name;

    @JacksonXmlProperty(localName = "address")
    private Address address;

    @JacksonXmlProperty(localName = "daytimePhoneNbr")
    private String daytimePhoneNbr;

    @JacksonXmlProperty(localName = "homePhoneNbr")
    private String homePhoneNbr;

    @JacksonXmlProperty(localName = "alternatePhoneNbr")
    private String alternatePhoneNbr;

    @JacksonXmlProperty(localName = "sendSMSMessage")
    private boolean sendSMSMessage;

    @JacksonXmlProperty(localName = "emailAddress")
    private String emailAddress;

    @JacksonXmlProperty(localName = "seperatorContact0")
    private int separatorContact0;

    public Contact() {
    }

    public Contact(int custID, Name name, Address address, String daytimePhoneNbr, String homePhoneNbr, String alternatePhoneNbr, boolean sendSMSMessage, String emailAddress, int separatorContact0) {
        this.custID = custID;
        this.name = name;
        this.address = address;
        this.daytimePhoneNbr = daytimePhoneNbr;
        this.homePhoneNbr = homePhoneNbr;
        this.alternatePhoneNbr = alternatePhoneNbr;
        this.sendSMSMessage = sendSMSMessage;
        this.emailAddress = emailAddress;
        this.separatorContact0 = separatorContact0;
    }

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDaytimePhoneNbr() {
        return daytimePhoneNbr;
    }

    public void setDaytimePhoneNbr(String daytimePhoneNbr) {
        this.daytimePhoneNbr = daytimePhoneNbr;
    }

    public String getHomePhoneNbr() {
        return homePhoneNbr;
    }

    public void setHomePhoneNbr(String homePhoneNbr) {
        this.homePhoneNbr = homePhoneNbr;
    }

    public String getAlternatePhoneNbr() {
        return alternatePhoneNbr;
    }

    public void setAlternatePhoneNbr(String alternatePhoneNbr) {
        this.alternatePhoneNbr = alternatePhoneNbr;
    }

    public boolean isSendSMSMessage() {
        return sendSMSMessage;
    }

    public void setSendSMSMessage(boolean sendSMSMessage) {
        this.sendSMSMessage = sendSMSMessage;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getSeparatorContact0() {
        return separatorContact0;
    }

    public void setSeparatorContact0(int separatorContact0) {
        this.separatorContact0 = separatorContact0;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "custID=" + custID +
                ", name=" + name +
                ", address=" + address +
                ", daytimePhoneNbr='" + daytimePhoneNbr + '\'' +
                ", homePhoneNbr='" + homePhoneNbr + '\'' +
                ", alternatePhoneNbr='" + alternatePhoneNbr + '\'' +
                ", sendSMSMessage=" + sendSMSMessage +
                ", emailAddress='" + emailAddress + '\'' +
                ", separatorContact0=" + separatorContact0 +
                '}';
    }
}