package com.leantech.demo.controller;

import com.leantech.demo.entitiy.Employee;
import com.leantech.demo.payload.EmployeeResponse;
import com.leantech.demo.payload.NewEmployeePersonRequest;
import com.leantech.demo.payload.NewEmployeeRequest;
import com.leantech.demo.payload.PositionResponse;
import com.leantech.demo.service.EmployeeService;
import com.leantech.demo.service.PersonService;
import com.leantech.demo.service.PositionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "API Rest de empleados", description = "Operations to handle CRUD Employee")
@RestController
@RequestMapping("/v1/api")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    PersonService personService;

    @Autowired
    PositionService positionService;

    @PostMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Añadir un nuevo empleado con el id de la persona y el id de la posicion", response = Employee.class)
    public ResponseEntity<Employee> addEmployee(@RequestBody NewEmployeeRequest newEmployeeRequest) {
        try {
            Employee _employee = employeeService.add(newEmployeeRequest);
            return new ResponseEntity<>(_employee, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/employee/person", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Añandir un empleado desde el id del posicion y la data de una nueva persona", response = Employee.class)
    public ResponseEntity<Employee> addEmployeeWithPerson(@RequestBody NewEmployeePersonRequest NewEmployeePersonRequest) {
        try {
            Employee _employee = employeeService.addWithPerson(NewEmployeePersonRequest, personService);
            return new ResponseEntity<>(_employee, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Actualizar un empleado", response = Employee.class)
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody NewEmployeeRequest newEmployeeRequest) {
        try {
            employeeService.update(id, newEmployeeRequest);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/employe")
    @ApiOperation(value = "Listar todos los empleados (Este Endpoint debe permitir filtrar por cargo o nombre)\n" +
            "estos parámetros son opcionales, si no se envía alguno de estos, debe traer todos los\n" +
            "empleados.\n", response = Employee.class, responseContainer = "List")
    public ResponseEntity<List<EmployeeResponse>> getAll(@RequestParam(required = false) String position, @RequestParam(required = false) String name) {
        try {
            List<EmployeeResponse> list;

            if (position != null) {
                list = new ArrayList<>();
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
    @ApiOperation(value = "Eliminar Empleado", response = HttpStatus.class)
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") long id) {
        try {
            employeeService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/employee/all")
    @ApiOperation(value = "Retornar una lista con todos los cargos, y dentro de los cargos todos los empleados\n" +
            "ordenados por salario de mayor a menor", response = PositionResponse.class, responseContainer = "List")
    public ResponseEntity<List<PositionResponse>> getAllv2() {
        try {
            List<PositionResponse> per = positionService.getAllv2(employeeService);
            return new ResponseEntity<>(per, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
