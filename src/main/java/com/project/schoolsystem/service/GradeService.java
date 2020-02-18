package com.project.schoolsystem.service;

import com.project.schoolsystem.model.Grade;
import com.project.schoolsystem.model.Student;
import com.project.schoolsystem.repository.GradeRepository;
import com.project.schoolsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {
    private final GradeRepository gradeRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public GradeService(GradeRepository gradeRepository, StudentRepository studentRepository) {
        this.gradeRepository = gradeRepository;
        this.studentRepository = studentRepository;
    }

    public List<Grade> listAll(String studentId) {
        List<Grade> grades = null;
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (studentOptional.isPresent())
            grades = studentOptional.get().getGrades();
        return grades;
    }

    public Optional<Grade> getOptionalById(Long id) {
        return gradeRepository.findById(id);
    }

    public Grade save(Grade grade) {
        return gradeRepository.save(grade);
    }

    public void update(Grade grade) {
        gradeRepository.save(grade);
    }

    public void delete(Long id) {
        Optional<Grade> optional = getOptionalById(id);
        optional.ifPresent(gradeRepository::delete);
    }
}
