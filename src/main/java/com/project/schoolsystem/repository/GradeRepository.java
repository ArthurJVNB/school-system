package com.project.schoolsystem.repository;

import com.project.schoolsystem.model.Grade;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GradeRepository extends PagingAndSortingRepository<Grade, Long> {
}
