package io.lightfeather.springtemplate.dto;

import io.lightfeather.springtemplate.model.Manager;

import java.io.Serializable;

public class ManagerResponse implements Serializable {

    private String firstName;

    private String lastName;

    private Character jurisdiction;

    private String phone;


    public static ManagerResponse from(Manager manager) {
        if (manager == null) {
            return null;
        }

        return new ManagerResponse()
                .withFirstName(manager.getFirstName())
                .withLastName(manager.getLastName())
                .withJurisdiction(manager.getJurisdiction())
                .withPhone(manager.getPhone());
    }


    public ManagerResponse withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ManagerResponse withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ManagerResponse withJurisdiction(Character jurisdiction) {
        this.jurisdiction = jurisdiction;
        return this;
    }

    public ManagerResponse withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getSupervisor() {
        return jurisdiction + " - " + lastName + ", " + firstName;
    }
}
