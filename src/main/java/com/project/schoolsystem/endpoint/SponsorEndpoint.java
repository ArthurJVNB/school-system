package com.project.schoolsystem.endpoint;

import com.project.schoolsystem.model.Sponsor;
import com.project.schoolsystem.service.ServiceCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "ap1/v1/sponsors")
public class SponsorEndpoint extends AbstractEndpoint<Sponsor, String> {
    @Autowired
    public SponsorEndpoint(ServiceCrud<Sponsor, String> service) {
        super(service);
    }
}
