package com.leantech.demo.repository;

import com.leantech.demo.entitiy.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
