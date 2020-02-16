package com.project.schoolsystem.endpoint;

import com.project.schoolsystem.model.Grade;
import com.project.schoolsystem.service.ServiceCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "ap1/v1/grade")
public class GradeEndpoint extends AbstractEndpoint<Grade, Long> {
    @Autowired
    public GradeEndpoint(ServiceCrud<Grade, Long> service) {
        super(service);
    }
}
