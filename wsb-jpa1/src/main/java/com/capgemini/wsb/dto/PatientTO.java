package com.capgemini.wsb.dto;

import java.io.Serializable;
import java.util.List;

public class PatientTO implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Double weight;
    private List<VisitTO> visits;

    public PatientTO() {

    }

    public PatientTO(Long id, String firstName, String lastName, String email, Double weight, List<VisitTO> visits) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.weight = weight;
        this.visits = visits;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public List<VisitTO> getVisits() {
        return visits;
    }

    public void setVisits(List<VisitTO> visits) {
        this.visits = visits;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
