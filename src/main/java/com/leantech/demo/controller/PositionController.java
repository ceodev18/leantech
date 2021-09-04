package com.leantech.demo.controller;

import com.leantech.demo.entitiy.Position;
import com.leantech.demo.payload.NewPositionRequest;
import com.leantech.demo.payload.PositionResponse;
import com.leantech.demo.service.EmployeeService;
import com.leantech.demo.service.PositionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "API Rest de posicion", description = "Operaciones añadir o listar")
@RestController
@RequestMapping("/v1/api")
public class PositionController {
    @Autowired
    PositionService positionService;
    @Autowired
    EmployeeService employeeService;

    @PostMapping(value = "/position", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Añadir una posicion", response = Position.class)
    public ResponseEntity<Position> addPosition(@RequestBody NewPositionRequest newPositionRequest) {
        try {
            Position _position = positionService.add(Position.builder().name(newPositionRequest.getName()).build());
            return new ResponseEntity<>(_position, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/position", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Actualizar a position", response = Position.class)
    public ResponseEntity<Position> updatePosition(@RequestBody Position position) {
        try {
            Position _position = positionService.update(position);
            return new ResponseEntity<>(_position, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/position")
    @ApiOperation(value = "Listar todas las posiciones", response = Position.class, responseContainer = "List")
    public ResponseEntity<List<Position>> getAll() {
        try {
            List<Position> list = positionService.getAll();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/position/{id}")
    @ApiOperation(value = "Consultar una posicion", response = Position.class)
    public ResponseEntity<Position> getOne(@PathVariable("id") long id) {
        try {
            Position _position = positionService.getOne(id);
            return new ResponseEntity<>(_position, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
