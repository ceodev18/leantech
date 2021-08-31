package com.leantech.demo.repository;

import com.leantech.demo.entitiy.Employee;
import com.leantech.demo.entitiy.Person;
import com.leantech.demo.entitiy.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT e FROM Employee e WHERE e.position = ?1")
    List<Employee> findByPosition(Position position);

    @Query("SELECT e FROM Employee e WHERE e.position = ?1 order by e.salary desc ")
    List<Employee> findByPositionSorted(Position position);



}
