package com.project.schoolsystem.repository;

import com.project.schoolsystem.model.School;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SchoolRepository extends PagingAndSortingRepository<School, String> {
    School findByName(String name);
}
