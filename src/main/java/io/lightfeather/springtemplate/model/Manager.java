package io.lightfeather.springtemplate.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.UUID;

public class Manager implements Comparable<Manager>{

    private Integer id;

    private String phone;

    private Character jurisdiction;

    private String firstName;

    private String lastName;

    private UUID identificationNumber;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setJurisdiction(Character jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UUID getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(UUID idintificationNumber) {
        this.identificationNumber = idintificationNumber;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public Character getJurisdiction() {
        return jurisdiction;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public int compareTo(Manager compManager) {
        if (this.jurisdiction.compareTo(compManager.jurisdiction) != 0) {
            return this.jurisdiction.compareTo(compManager.jurisdiction);
        }
        if (this.jurisdiction.compareTo(compManager.jurisdiction) == 0) {
            if (this.lastName.compareToIgnoreCase(compManager.lastName) != 0)
                return this.lastName.compareToIgnoreCase(compManager.lastName);
        }
        return 0;
    }

    public String toString() {
        return jurisdiction + " - " + lastName + ", " + firstName;
    }
}