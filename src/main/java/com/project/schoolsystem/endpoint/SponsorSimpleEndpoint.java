package com.project.schoolsystem.endpoint;

import com.project.schoolsystem.model.Sponsor;
import com.project.schoolsystem.service.SimpleServiceCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/sponsors")
public class SponsorSimpleEndpoint extends AbstractSimpleEndpoint<Sponsor, String> {
    @Autowired
    public SponsorSimpleEndpoint(@Qualifier("sponsorSimpleService") SimpleServiceCrud<Sponsor, String> service) {
        super(service);
    }
}
