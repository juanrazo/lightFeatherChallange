package io.lightfeather.springtemplate.controller;

import io.lightfeather.springtemplate.dto.EmployeeRequest;
import io.lightfeather.springtemplate.dto.ManagerResponse;
import io.lightfeather.springtemplate.response.Response;
import io.lightfeather.springtemplate.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @GetMapping("/api/supervisors")
    public List<ManagerResponse> getSupervisors() {
        try {
            return managerService.getAllManagers();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
       return List.of();
    }

    @PostMapping("/api/submit")
    public Response saveEmployee(
           @Valid EmployeeRequest employeeRequest,
           BindingResult bindingResult
    ) {
        Response response = new Response(employeeRequest);
        if (!bindingResult.hasErrors()) {
            System.out.println(employeeRequest);
            response.setMessage("Success");
        }

        else {
            response.setMessage("Missing Parameter");
        }
        return response;
    }

}