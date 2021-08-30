package com.leantech.demo.service.impl;

import com.leantech.demo.entitiy.Employee;
import com.leantech.demo.repository.EmployeeRepository;
import com.leantech.demo.service.EmployeeService;
import com.leantech.demo.util.Handler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee add(Employee employee) {
        Employee _employee= employeeRepository.save(employee);
        return _employee;
    }

    @Override
    public Employee update(Employee employee) {
        Employee existing = employeeRepository.findById(employee.getId()).get();
        Handler.copyNonNullProperties(employee, existing);
        Employee _employee = employeeRepository.save(existing);
        return _employee;
    }
}
