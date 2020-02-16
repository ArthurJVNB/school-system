package com.project.schoolsystem.endpoint;

import com.project.schoolsystem.model.School;
import com.project.schoolsystem.service.SchoolService;
import com.project.schoolsystem.service.ServiceCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@RestController
public abstract class AbstractEndpoint<T, IdType> {
    protected final ServiceCrud<T, IdType> service;

    @Autowired
    public AbstractEndpoint(ServiceCrud<T, IdType> service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(service.listAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable(value = "id") IdType id) {
        Optional<T> optional = service.getOptionalById(id);
        if (optional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(optional.get(), HttpStatus.OK);
    }

    @PostMapping
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> save(@Valid @NotNull @RequestBody T t) {
        return new ResponseEntity<>(service.save(t), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> delete(@PathVariable IdType id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid @NotNull @RequestBody T t) {
        service.update(t);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
