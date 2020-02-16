package com.project.schoolsystem.service;

import java.util.List;
import java.util.Optional;

public interface ServiceCrud<T, IdType> {
    List<T> listAll();
    Optional<T> getOptionalById(IdType id);
    T save(T t);
    void update(T t);
    void delete(IdType id);
}
