package com.project.schoolsystem.endpoint;

import com.project.schoolsystem.model.Student;
import com.project.schoolsystem.service.ServiceCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "ap1/v1/students")
public class StudentEndpoint extends AbstractEndpoint<Student, String> {
    @Autowired
    public StudentEndpoint(ServiceCrud<Student, String> service) {
        super(service);
    }
}
