package com.leantech.demo.controller;


import com.leantech.demo.entitiy.Person;
import com.leantech.demo.entitiy.Position;
import com.leantech.demo.payload.NewPersonRequest;
import com.leantech.demo.service.PersonService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class PersonController {
    @Autowired
    PersonService personService;

    @PostMapping(value = "/person", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Adding a new person", response = Person.class)
    public ResponseEntity<Person> addPerson(@RequestBody NewPersonRequest newPersonRequest) {
        try {
            Person _person = personService.add(newPersonRequest);
            return new ResponseEntity<>(_person, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/person")
    @ApiOperation(value = "Get all persons", response = Person.class, responseContainer = "List")
    public ResponseEntity<List<Person>> getAll() {
        try {
            List<Person> list = personService.getAll();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

