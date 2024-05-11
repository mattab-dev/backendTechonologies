package com.capgemini.wsb.dto;

import java.io.Serializable;

public class SimplePatientTO implements Serializable {
    private String firstName;
    private String lastName;

    public SimplePatientTO() {

    }

    public SimplePatientTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
}
