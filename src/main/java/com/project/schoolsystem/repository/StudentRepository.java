package com.project.schoolsystem.repository;

import com.project.schoolsystem.model.Student;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentRepository extends PagingAndSortingRepository<Student, String> {
    Student findByName(String name);
}
