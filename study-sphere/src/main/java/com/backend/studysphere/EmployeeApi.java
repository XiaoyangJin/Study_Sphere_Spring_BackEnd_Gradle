package com.backend.studysphere;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeApi {

    //expose an end point to get
    @GetMapping("/{empId}")
    public String getEmployee(String empId){
        return "Employee Found";
    }
}
