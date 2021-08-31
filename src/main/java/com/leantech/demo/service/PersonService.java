package com.leantech.demo.service;

import com.leantech.demo.entitiy.Person;
import com.leantech.demo.payload.NewPersonRequest;
import com.leantech.demo.service.impl.PersonServiceImpl;

import java.util.List;

public interface PersonService {
    Person add(final NewPersonRequest newPersonRequest);

    List<Person> getAll();
}
