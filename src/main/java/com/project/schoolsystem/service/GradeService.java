package com.project.schoolsystem.service;

import com.project.schoolsystem.model.Grade;
import com.project.schoolsystem.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GradeService implements ServiceCrud<Grade, Long> {
    private final GradeRepository repository;

    @Autowired
    public GradeService(GradeRepository repository) {
        this.repository = repository;
    }

    public List<Grade> listAll() {
        List<Grade> list = new ArrayList<>();
        Iterable<Grade> iterable = repository.findAll();
        for (Grade grade : iterable) {
            list.add(grade);
        }
        return list;
    }

    public Optional<Grade> getOptionalById(Long id) {
        return repository.findById(id);
    }

    public Grade save(Grade grade) {
        return repository.save(grade);
    }

    public void update(Grade grade) {
        repository.save(grade);
    }

    public void delete(Long id) {
        Optional<Grade> optional = getOptionalById(id);
        optional.ifPresent(repository::delete);
    }
}
