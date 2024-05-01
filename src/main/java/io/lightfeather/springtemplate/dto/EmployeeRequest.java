package io.lightfeather.springtemplate.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;


@ApiModel(description = "Parameters for creating an employee")
public class EmployeeRequest {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private String email;

    private String phoneNumber;

    @NotNull
    private Boolean supervisor;


    @ApiModelProperty(
            value = "First name for employee",
            example = "John",
            required = true
    )
    public String getFirstName() {
        return firstName;
    }

    @ApiModelProperty(
            value = "Last name for employee",
            example = "Doe",
            required = true
    )
    public String getLastName() {
        return lastName;
    }

    @ApiModelProperty(
            value = "Email for employee",
            example = "JohnDoe@email.com",
            required = false
    )
    public String getEmail() {
        return email;
    }

    @ApiModelProperty(
            value = "Phone number for employee",
            example = "555-867-5309",
            required = false
    )
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @ApiModelProperty(
            value = "Boolean for Supervisor",
            example = "true or false",
            required = true
    )
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
