package com.leantech.demo;

import com.leantech.demo.entitiy.Person;
import com.leantech.demo.repository.PersonRepository;
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
public class PersonRepositoryTests {


    @Autowired
    private PersonRepository personRepository;


    @Test
    @Order(1)
    @Rollback(value = false)
    public void testSaveNewPerson() {
        Person current = new Person();
        current.setName("Christian");
        current.setLastName("Espinoza");
        current.setCityName("Lima");
        current.setCellphone("999333111");
        current.setAddress("Los Olivos");
        current = personRepository.save(current);


        Assertions.assertThat(current.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getPersonTest() {

        Person person = personRepository.findById(1L).get();
        Assertions.assertThat(person).isNotNull();

    }
    @Test
    @Order(3)
    public void getListOfPersonTest(){

        List<Person> personList = personRepository.findAll();

        Assertions.assertThat(personList.size()).isGreaterThan(0);

    }

}
