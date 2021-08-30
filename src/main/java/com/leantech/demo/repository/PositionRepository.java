package com.leantech.demo.repository;


import com.leantech.demo.entitiy.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {
}
