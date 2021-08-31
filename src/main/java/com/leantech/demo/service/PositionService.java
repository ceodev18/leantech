package com.leantech.demo.service;


import com.leantech.demo.entitiy.Position;
import com.leantech.demo.payload.PersonResponse;
import com.leantech.demo.payload.PositionResponse;

import java.util.List;

public interface PositionService {
    Position add(final Position employee);

    Position update(final Position employee);

    void delete(long id);

    List<Position> getAll();

    Position getOne(long id);

    List<PositionResponse> getAllv2(EmployeeService employeeService);
}
