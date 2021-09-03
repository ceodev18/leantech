package com.leantech.demo.repository;


import com.leantech.demo.entitiy.Employee;
import com.leantech.demo.entitiy.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface PositionRepository extends JpaRepository<Position, Long> {
    @Query("SELECT p FROM Position p WHERE p.name = ?1")
    Position findByName(String name);
}
