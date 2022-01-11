package com.macys.macysordermessageproducer.dto.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.io.Serializable;

public class Name implements Serializable {

    @JacksonXmlProperty(localName = "firstName")
    private String firstName;

    @JacksonXmlProperty(localName = "lastName")
    private String lastName;

    @JacksonXmlProperty(localName = "seperatorName0")
    private int separatorName0;

    @JacksonXmlProperty(localName = "seperatorName1")
    private int separatorName1;

    public Name() {
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSeparatorName0() {
        return separatorName0;
    }

    public void setSeparatorName0(int separatorName0) {
        this.separatorName0 = separatorName0;
    }

    public int getSeparatorName1() {
        return separatorName1;
    }

    public void setSeparatorName1(int separatorName1) {
        this.separatorName1 = separatorName1;
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", separatorName0=" + separatorName0 +
                ", separatorName1=" + separatorName1 +
                '}';
    }
}