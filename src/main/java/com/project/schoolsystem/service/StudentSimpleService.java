package com.project.schoolsystem.service;

import com.project.schoolsystem.model.Student;
import com.project.schoolsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentSimpleService implements SimpleServiceCrud<Student, String> {
    private final StudentRepository repository;

    @Autowired
    public StudentSimpleService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> listAll() {
        List<Student> list = new ArrayList<>();
        Iterable<Student> iterable = repository.findAll();
        for (Student student : iterable) {
            list.add(student);
        }
        return list;
    }

    public Optional<Student> getOptionalById(String id) {
        return repository.findById(id);
    }

    public Student save(Student student) {
        return repository.save(student);
    }

    public void update(Student student) {
        repository.save(student);
    }

    public void delete(String id) {
        Optional<Student> optional = getOptionalById(id);
        optional.ifPresent(repository::delete);
    }
}
