package com.leantech.demo.service.impl;

import com.leantech.demo.entitiy.Person;
import com.leantech.demo.payload.NewPersonRequest;
import com.leantech.demo.repository.PersonRepository;
import com.leantech.demo.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository personRepository;

    @Override
    public Person add(NewPersonRequest newPersonRequest) {
        Person person = new Person(newPersonRequest);
        person = personRepository.save(person);
        return person;
    }

    @Override
    public List<Person> getAll() {
        List<Person> personList = personRepository.findAll();
        return personList;
    }
}
