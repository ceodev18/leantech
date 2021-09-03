package com.leantech.demo;

import com.leantech.demo.entitiy.Person;
import com.leantech.demo.entitiy.Position;
import com.leantech.demo.repository.PersonRepository;
import com.leantech.demo.repository.PositionRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;


@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PositionRepositoryTests {


    @Autowired
    private PositionRepository positionRepository;

    @BeforeEach
    void setUp() {
        positionRepository.save(Position.builder().name("Position 1").id(1L).build());
    }
    @Test
    @Order(1)
    @Rollback(value = false)
    public void testSaveNewPosition() {
        Position position = Position.builder().name("scrum-master").build();

        position = positionRepository.save(position);

        Assertions.assertThat(position.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getPositionByName() {

        Position position = positionRepository.findByName("Position 1");
        Assertions.assertThat(position.getName()).isEqualTo("Position 1");
    }
    @Test
    @Order(3)
    public void getPositionById() {

        Position position = positionRepository.findById(Long.valueOf(1)).get();
        Assertions.assertThat(position.getId()).isEqualTo(Long.valueOf(1));

    }

    @Test
    @Order(4)
    public void getListOfPositionTest() {

        List<Position> positionList = positionRepository.findAll();

        Assertions.assertThat(positionList.size()).isGreaterThan(0);

    }

}
