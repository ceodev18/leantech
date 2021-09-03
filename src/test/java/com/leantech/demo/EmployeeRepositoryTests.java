package com.leantech.demo;

import com.leantech.demo.entitiy.Employee;

import com.leantech.demo.entitiy.Person;
import com.leantech.demo.entitiy.Position;
import com.leantech.demo.repository.EmployeeRepository;

import com.leantech.demo.repository.PersonRepository;
import com.leantech.demo.repository.PositionRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;


@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeRepositoryTests {


    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PositionRepository positionRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void testSaveNewEmployee() {
        // given
        Employee employee = new Employee();
        employee.setSalary(1000.0F);

        Person person = new Person();
        person.setAddress("Address");
        person.setCellphone("999333111");
        person.setName("Name");
        person.setLastName("Lastname");
        person = personRepository.save(person);
        employee.setPerson(person);

        Position position = Position.builder().name("namePosition").build();
        position = positionRepository.save(position);
        employee.setPosition(position);

        // when
        employee = employeeRepository.save(employee);

        // then
        Assertions.assertThat(employee.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getPersonTest() {

        Employee employee = employeeRepository.getById(Long.valueOf(66));
        Assertions.assertThat(employee.getId()).isEqualTo(Long.valueOf(66));

    }

    @Test
    @Order(3)
    public void getListOfPersonTest() {

        List<Employee> employeeList = employeeRepository.findAll();

        Assertions.assertThat(employeeList.size()).isGreaterThan(0);

    }

}
