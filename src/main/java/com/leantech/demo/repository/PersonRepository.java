package com.leantech.demo.repository;


import com.leantech.demo.entitiy.Employee;
import com.leantech.demo.entitiy.Person;
import com.leantech.demo.entitiy.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    //@Query("SELECT e FROM Person e WHERE e. = ?1")
    //List<Employee> findByPositionId(Position position);
}
