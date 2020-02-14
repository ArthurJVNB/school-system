package com.project.schoolsystem.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Student {
    @Id
    private String enrollment;
    private String name;
    private String grade;
    @OneToMany(mappedBy = "student",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Grade> grades = new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY)
    private Sponsor sponsor;
    @ManyToOne(fetch = FetchType.LAZY)
    private School school;

    public void addGrade(Grade grade) {
        grades.add(grade);
        grade.setStudent(this);
    }

    public void removeGrade(Grade grade) {
        grades.remove(grade);
        grade.setStudent(null);
    }

    public String getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public Sponsor getSponsor() {
        return sponsor;
    }

    public void setSponsor(Sponsor sponsor) {
        this.sponsor = sponsor;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(enrollment, student.enrollment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enrollment);
    }
}
