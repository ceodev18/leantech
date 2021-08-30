package com.leantech.demo.service.impl;

import com.leantech.demo.entitiy.Position;
import com.leantech.demo.repository.PositionRepository;
import com.leantech.demo.service.PositionService;
import com.leantech.demo.util.Handler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PositionServiceImpl implements PositionService {
    @Autowired
    PositionRepository positionRepository;
    @Override
    public Position add(Position position) {
        Position _position= positionRepository.save(position);
        return _position;

    }

    @Override
    public Position update(Position position) {
        Position existing = positionRepository.findById(position.getId()).get();
        Handler.copyNonNullProperties(position, existing);
        Position _position = positionRepository.save(existing);
        return _position;
    }

    @Override
    public void delete(long id) {
        positionRepository.delete(positionRepository.findById(id).get());
    }

    @Override
    public List<Position> getAll() {
        return positionRepository.findAll();
    }

    @Override
    public Position getOne(long id) {
        return positionRepository.findById(id).get();
    }
}