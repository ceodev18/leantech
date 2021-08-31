package com.leantech.demo;

import com.leantech.demo.entitiy.Employee;
import com.leantech.demo.entitiy.Person;
import com.leantech.demo.entitiy.Position;
import com.leantech.demo.repository.EmployeeRepository;
import com.leantech.demo.repository.PersonRepository;
import com.leantech.demo.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class LeantechApplication implements CommandLineRunner {
    @Autowired
    PersonRepository personRepository;

    @Autowired
    PositionRepository positionRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(LeantechApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        saveData();
    }
    @Transactional
    public void saveData() {
        /*Position position = new Position();
        position.setName("dev");
        position = positionRepository.save(position);
        System.out.println(position.toString());



        Person person = new Person();
        person.setName("Italo");
        person.setLastName("Espinoza");
        person.setCellphone("916388047");
        person = personRepository.save(person);
        System.out.println(person.toString());

        Employee employee = new Employee();
        employee.setSalary(10000f);
        employee.setPosition(position);
        employee.setPerson(person);
        employee = employeeRepository.save(employee);
        System.out.println(employee.toString());*/

    }
}
