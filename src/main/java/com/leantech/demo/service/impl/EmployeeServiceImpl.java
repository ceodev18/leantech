package com.leantech.demo.service.impl;

import com.leantech.demo.entitiy.Employee;
import com.leantech.demo.entitiy.Person;
import com.leantech.demo.entitiy.Position;
import com.leantech.demo.payload.*;
import com.leantech.demo.repository.EmployeeRepository;
import com.leantech.demo.repository.PersonRepository;
import com.leantech.demo.repository.PositionRepository;
import com.leantech.demo.service.EmployeeService;
import com.leantech.demo.service.PersonService;
import com.leantech.demo.util.Handler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PositionRepository positionRepository;

    @Override
    public Employee add(NewEmployeeRequest employeeRequesto) {
        log.info("Adding new employee");
        Person _person = personRepository.findById(employeeRequesto.getPerson_id()).get();
        Position _position = positionRepository.findById(employeeRequesto.getPosition_id()).get();

        Employee employee = employeeRepository.save(Employee.builder()
                .salary(employeeRequesto.getSalary())
                .position(_position)
                .person(_person)
                .build());

        personRepository.save(_person);
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        Employee existing = employeeRepository.findById(employee.getId()).get();
        Handler.copyNonNullProperties(employee, existing);
        Employee _employee = employeeRepository.save(existing);
        return _employee;
    }

    @Override
    public List<Employee> getAll() {
        log.info("Retrieving all user");
        return employeeRepository.findAll();
    }

    @Override
    public List<EmployeeResponse> getAllResponse(Position position) {

        List<EmployeeResponse> list = new ArrayList<>();
        for (Employee e : employeeRepository.findByPositionSorted(position)) {
            Person p = e.getPerson();
            list.add(EmployeeResponse.builder()
                    .id(e.getId())
                    .salary(e.getSalary())
                    .person(PersonResponse.builder()
                            .name(p.getName())
                            .lastName(p.getLastName())
                            .address(p.getAddress())
                            .cellphone(p.getCellphone())
                            .cityName(p.getCityName())
                            .build())
                    .build()
            );

        }

        //Collections.sort(list, Comparator.comparingDouble(EmployeeResponse ::getSalary));


        return list;
    }

    @Override
    public List<EmployeeResponse> getAllResponse() {
        List<EmployeeResponse> list = new ArrayList<>();
        for (Employee e : employeeRepository.findAll()) {
            Person p = e.getPerson();
            list.add(EmployeeResponse.builder()
                    .id(e.getId())
                    .salary(e.getSalary())
                    .person(PersonResponse.builder()
                            .name(p.getName())
                            .lastName(p.getLastName())
                            .address(p.getAddress())
                            .cellphone(p.getCellphone())
                            .cityName(p.getCityName())
                            .build())
                    .build()
            );

        }
        return list;
    }

    @Override
    public List<EmployeeResponse> getAllResponseByPosition(String position) {
        List<EmployeeResponse> list = new ArrayList<>();
        for (Employee e : employeeRepository.findAll()) {
            Person p = e.getPerson();
            list.add(EmployeeResponse.builder()
                    .id(e.getId())
                    .salary(e.getSalary())
                    .person(PersonResponse.builder()
                            .name(p.getName())
                            .lastName(p.getLastName())
                            .address(p.getAddress())
                            .cellphone(p.getCellphone())
                            .cityName(p.getCityName())
                            .build())
                    .build()
            );

        }
        return list;
    }

    @Override
    public Employee addWithPerson(NewEmployeePersonRequest newEmployeePersonRequest, PersonService personService) {
        Position _position = positionRepository.findById(newEmployeePersonRequest.getPosition_id()).get();
        Person _person = personService.add(newEmployeePersonRequest.getNewPersonRequest());


        Employee employee = employeeRepository.save(Employee.builder()
                .person(_person)
                .position(_position)
                .salary(newEmployeePersonRequest.getSalary()).build());

        return employee;

    }

    @Override
    public void delete(long id) {
        employeeRepository.deleteById(id);
    }
}
