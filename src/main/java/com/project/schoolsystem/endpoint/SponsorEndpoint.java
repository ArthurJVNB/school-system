package com.project.schoolsystem.endpoint;

import com.project.schoolsystem.model.Sponsor;
import com.project.schoolsystem.service.SimpleServiceCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "ap1/v1/sponsors")
public class SponsorEndpoint extends AbstractGenericEndpoint<Sponsor, String> {

    @Autowired
    public SponsorEndpoint(SimpleServiceCrud<Sponsor, String> service) {
        super(service);
    }
}
