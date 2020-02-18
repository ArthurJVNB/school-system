package com.project.schoolsystem.endpoint;

import com.project.schoolsystem.model.School;
import com.project.schoolsystem.model.Sponsor;
import com.project.schoolsystem.service.SimpleServiceCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/schools")
public class SchoolSimpleEndpoint extends AbstractSimpleEndpoint<School, String> {
    private final SimpleServiceCrud<Sponsor, String> sponsorService;

    @Autowired
    public SchoolSimpleEndpoint(@Qualifier("schoolSimpleService") SimpleServiceCrud<School, String> service, @Qualifier("sponsorSimpleService") SimpleServiceCrud<Sponsor, String> sponsorService) {
        super(service);
        this.sponsorService = sponsorService;
    }

    @PostMapping(path = "sponsors/{idSchool}")
    public ResponseEntity<?> addSponsor(@PathVariable("idSchool") String idSchool, @RequestBody Sponsor sponsor) {
        Optional<School> schoolOptional = service.getOptionalById(idSchool);
        if (schoolOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        School school = schoolOptional.get();
        school.addSponsor(sponsor);
        sponsor.setSchool(school);
        return new ResponseEntity<>(sponsorService.save(sponsor), HttpStatus.OK);
    }

    @DeleteMapping(path = "sponsors/{idSchool}")
    public ResponseEntity<?> removeSponsor(@PathVariable("idSchool") String idSchool, @RequestBody Sponsor sponsor) {
        Optional<School> schoolOptional = service.getOptionalById(idSchool);
        if (schoolOptional.isPresent()) {
            School school = schoolOptional.get();
            school.removeSponsor(sponsor);
            sponsor.setSchool(null);
            sponsorService.delete(sponsor.getCpf());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
