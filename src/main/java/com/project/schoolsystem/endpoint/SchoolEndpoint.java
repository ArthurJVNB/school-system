package com.project.schoolsystem.endpoint;

import com.project.schoolsystem.model.School;
import com.project.schoolsystem.service.ServiceCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "api/v1/schools")
public class SchoolEndpoint extends AbstractEndpoint<School, String> {
    @Autowired
    public SchoolEndpoint(ServiceCrud<School, String> service) {
        super(service);
    }
}
