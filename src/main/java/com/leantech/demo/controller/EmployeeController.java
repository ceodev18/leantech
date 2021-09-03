package com.leantech.demo.controller;

import com.leantech.demo.entitiy.Employee;
import com.leantech.demo.payload.EmployeeResponse;
import com.leantech.demo.payload.NewEmployeePersonRequest;
import com.leantech.demo.payload.NewEmployeeRequest;
import com.leantech.demo.service.EmployeeService;
import com.leantech.demo.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Employee CRUD", description = "Operations to handle CRUD Employee")
@RestController
@RequestMapping("/v1/api")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    PersonService personService;

    @PostMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Adding a new employee with position id and person id", response = Employee.class)
    public ResponseEntity<Employee> addEmployee(@RequestBody NewEmployeeRequest newEmployeeRequest) {
        try {
            Employee _employee = employeeService.add(newEmployeeRequest);
            return new ResponseEntity<>(_employee, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/employee/person", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Adding a new employee with position id and person data", response = Employee.class)
    public ResponseEntity<Employee> addEmployeeWithPerson(@RequestBody NewEmployeePersonRequest NewEmployeePersonRequest) {
        try {
            Employee _employee = employeeService.addWithPerson(NewEmployeePersonRequest, personService);
            return new ResponseEntity<>(_employee, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Updating an employee", response = Employee.class)
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        try {
            Employee _employee = employeeService.update(employee);
            return new ResponseEntity<>(_employee, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/employe")
    @ApiOperation(value = "Get all employees", response = Employee.class, responseContainer = "List")
    public ResponseEntity<List<EmployeeResponse>> getAll(@RequestParam(required = false) String position, @RequestParam(required = false) String name) {
        try {
            List<EmployeeResponse> list;

            if (position != null) {
                list = employeeService.getAllResponseByPosition(position);
            } else if (name != null) {
                list = employeeService.getAllResponseByPosition(name);
            } else {
                list = employeeService.getAllResponse();
            }


            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/employee/{id}")
    @ApiOperation(value = "Delete employee", response = HttpStatus.class)
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") long id) {
        try {
            employeeService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
