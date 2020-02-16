package com.project.schoolsystem.endpoint;

import com.project.schoolsystem.model.Grade;
import com.project.schoolsystem.model.Student;
import com.project.schoolsystem.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "ap1/v1/grades")
public class GradeEndpoint {
    private final GradeService service;

    @Autowired
    public GradeEndpoint(GradeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> listAll(@RequestBody Student student) {
        return new ResponseEntity<>(service.listAll(), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<?> getById(@RequestBody Student student, @PathVariable("id") Long id) {
        List<Grade> grades = student.getGrades();
        Grade result = null;
        for (Grade grade : grades) {
            if (grade.getId().equals(id)) {
                result = grade;
                break;
            }
        }
        if (result == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(Grade grade) {
        return new ResponseEntity<>(service.save(grade), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(Grade grade) {
        service.update(grade);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> delete(@RequestBody Student student, @PathVariable("id") Long id) {
        List<Grade> grades = student.getGrades();
        for (Grade grade : grades) {
            if (grade.getId().equals(id)) {
                grades.remove(grade);
                break;
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
