package com.project.schoolsystem.service;

import com.project.schoolsystem.model.School;
import com.project.schoolsystem.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SchoolSimpleService implements SimpleServiceCrud<School, String> {
    private final SchoolRepository schoolRepository;

    @Autowired
    public SchoolSimpleService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public List<School> listAll() {
        List<School> schoolList = new ArrayList<>();
        Iterable<School> escolas = schoolRepository.findAll();
        for (School school : escolas) {
            schoolList.add(school);
        }
        return schoolList;
    }

    public Optional<School> getOptionalById(String id) {
        return schoolRepository.findById(id);
    }

    public School save(School school) {
        return schoolRepository.save(school);
    }

    public void update(School school) {
        schoolRepository.save(school);
    }

    public void delete(String id) {
        Optional<School> escolaOptional = getOptionalById(id);
        escolaOptional.ifPresent(schoolRepository::delete);
    }
}
