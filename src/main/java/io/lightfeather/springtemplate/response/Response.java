package io.lightfeather.springtemplate.response;

import io.lightfeather.springtemplate.dto.EmployeeRequest;

import java.io.Serializable;

public class Response implements Serializable {

    private EmployeeRequest employeeRequest;

    private String message;

    public Response(EmployeeRequest employeeRequest) {
        this.employeeRequest = employeeRequest;
    }

    public EmployeeRequest getEmployeeRequest() {
        return employeeRequest;
    }

    public String getMessage() {
        return message;
    }

    public void setEmployeeRequest(EmployeeRequest employeeRequest) {
        this.employeeRequest = employeeRequest;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
