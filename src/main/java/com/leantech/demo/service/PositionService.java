package com.leantech.demo.service;


import com.leantech.demo.entitiy.Position;

import java.util.List;

public interface PositionService {
    Position add(final Position employee);
    Position update(final Position employee);
    void delete(long id);
    List<Position> getAll();
    Position getOne(long id);
}
