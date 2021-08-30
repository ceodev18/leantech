package com.leantech.demo.controller;

import com.leantech.demo.entitiy.Position;
import com.leantech.demo.service.PositionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class PositionController {
    @Autowired
    PositionService positionService;

    @PostMapping(value = "/position", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Adding a new position", response = Position.class)
    public ResponseEntity<Position> addEmployee(@RequestBody Position position) {
        try {
            Position _position = positionService.add(position);
            return new ResponseEntity<>(_position, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/position", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Updating a position", response = Position.class)
    public ResponseEntity<Position> updateEmployee(@RequestBody Position position) {
        try {
            Position _position = positionService.update(position);
            return new ResponseEntity<>(_position, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/position/{id}")
    @ApiOperation(value = "Delete position", response = HttpStatus.class)
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        try {
            positionService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(value = "/position")
    @ApiOperation(value = "Get all positions", response = Position.class, responseContainer = "List")
    public ResponseEntity<List<Position>> getAll() {
        try {
            List<Position> list = positionService.getAll();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/position/{id}")
    @ApiOperation(value = "Get one position", response = Position.class)
    public ResponseEntity<Position> getOne(@PathVariable("id") long id) {
        try {
            Position _position = positionService.getOne(id);
            return new ResponseEntity<>(_position, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
