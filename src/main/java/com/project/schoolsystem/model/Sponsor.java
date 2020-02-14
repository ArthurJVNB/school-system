package com.project.schoolsystem.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "sponsor")
public class Sponsor {
    @Id
    private String cpf;
    private String name;
    @Email
    private String email;
    private String password;
    @ManyToOne(fetch = FetchType.LAZY)
    private School school;
    @OneToMany(mappedBy = "sponsor",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
        student.setSponsor(this);
    }

    public void removeStudent(Student student) {
        students.remove(student);
        student.setSponsor(null);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sponsor sponsor = (Sponsor) o;
        return Objects.equals(cpf, sponsor.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}
