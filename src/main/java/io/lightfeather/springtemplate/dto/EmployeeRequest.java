package io.lightfeather.springtemplate.dto;

import jakarta.validation.constraints.NotNull;


public class EmployeeRequest {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private String email;

    private String phoneNumber;

    @NotNull
    private Boolean supervisor;


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Boolean getSupervisor() {
        return supervisor;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSupervisor(Boolean supervisor) {
        this.supervisor = supervisor;
    }

    @Override
    public String toString() {
        return "EmployeeRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", supervisor=" + supervisor +
                '}';
    }
}
