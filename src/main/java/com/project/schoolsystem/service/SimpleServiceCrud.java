package com.project.schoolsystem.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface SimpleServiceCrud<T, IdType> {
    List<T> listAll();
    Optional<T> getOptionalById(IdType id);
    T save(T t);
    void update(T t);
    void delete(IdType id);
}
