package com.project.schoolsystem.repository;

import com.project.schoolsystem.model.Sponsor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SponsorRepository extends PagingAndSortingRepository<Sponsor, String> {
    Sponsor findByName(String name);
}
