package com.leantech.demo.controller;

import com.leantech.demo.entitiy.Employee;
import com.leantech.demo.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/api")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;


    @PostMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Adding a new employee category", response = Employee.class)
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        try {
            Employee _employee = employeeService.add(employee);
            return new ResponseEntity<>(_employee, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Updating an employee category", response = Employee.class)
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        try {
            Employee _employee = employeeService.update(employee);
            return new ResponseEntity<>(_employee, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
