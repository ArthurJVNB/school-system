package com.project.schoolsystem.endpoint;

import com.project.schoolsystem.model.Sponsor;
import com.project.schoolsystem.model.Student;
import com.project.schoolsystem.service.StudentSimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "ap1/v1/students")
public class StudentEndpoint {
    private final StudentSimpleService service;

    @Autowired
    public StudentEndpoint(StudentSimpleService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> listAll(@RequestBody Sponsor sponsor) {
        List<Student> students = sponsor.getStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<?> getById(@RequestBody Sponsor sponsor, @PathVariable("id") String id) {
        List<Student> students = sponsor.getStudents();
        Student result = null;
        for (Student student : students) {
            if (student.getEnrollment().equals(id)) {
                result = student;
                break;
            }
        }
        if (result == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(Student student) {
        return new ResponseEntity<>(service.save(student), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(Student student) {
        service.update(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> delete(@RequestBody Sponsor sponsor, @PathVariable("id") String id) {
        List<Student> students = sponsor.getStudents();
        Student result = null;
        for (Student student : students) {
            if (student.getEnrollment().equals(id)) {
                result = student;
                break;
            }
        }
        students.remove(result);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
