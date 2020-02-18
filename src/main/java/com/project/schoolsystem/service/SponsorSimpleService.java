package com.project.schoolsystem.service;

import com.project.schoolsystem.model.Sponsor;
import com.project.schoolsystem.repository.SponsorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SponsorSimpleService implements SimpleServiceCrud<Sponsor, String> {
    private final SponsorRepository sponsorRepository;

    @Autowired
    public SponsorSimpleService(SponsorRepository sponsorRepository) {
        this.sponsorRepository = sponsorRepository;
    }

    public List<Sponsor> listAll() {
        List<Sponsor> sponsorList = new ArrayList<>();
        Iterable<Sponsor> sponsors = sponsorRepository.findAll();
        for (Sponsor sponsor : sponsors) {
            sponsorList.add(sponsor);
        }
        return sponsorList;
    }

    public Optional<Sponsor> getOptionalById(String id) {
        return sponsorRepository.findById(id);
    }

    public Sponsor save(Sponsor sponsor) {
        return sponsorRepository.save(sponsor);
    }

    public void update(Sponsor sponsor) {
        sponsorRepository.save(sponsor);
    }

    public void delete(String id) {
        Optional<Sponsor> sponsorOptional = getOptionalById(id);
        sponsorOptional.ifPresent(sponsorRepository::delete);
    }
}
