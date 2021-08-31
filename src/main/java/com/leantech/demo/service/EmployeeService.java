package com.leantech.demo.service;

import com.leantech.demo.entitiy.Employee;
import com.leantech.demo.entitiy.Position;
import com.leantech.demo.payload.EmployeeResponse;
import com.leantech.demo.payload.NewEmployeePersonRequest;
import com.leantech.demo.payload.NewEmployeeRequest;

import java.util.List;


public interface EmployeeService {
    Employee add(final NewEmployeeRequest newEmployeeRequest);

    Employee update(final Employee employee);

    List<Employee> getAll();

    List<EmployeeResponse> getAllResponse(Position position);

    List<EmployeeResponse> getAllResponse();

    List<EmployeeResponse> getAllResponseByPosition(String position);

    Employee addWithPerson(final NewEmployeePersonRequest newEmployeePersonRequest, PersonService personService);

    void delete(long id);
}
