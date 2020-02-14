package com.project.schoolsystem.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "school")
public class School {
    @Id
    private String cnpj;
    private String name;
    private String password;
    @OneToMany(mappedBy = "school",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Sponsor> sponsors = new ArrayList<>();

    public void addSponsor(Sponsor sponsor) {
        sponsors.add(sponsor);
        sponsor.setSchool(this);
    }

    public void removeSponsor(Sponsor sponsor) {
        sponsors.remove(sponsor);
        sponsor.setSchool(null);
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Sponsor> getSponsors() {
        return sponsors;
    }

    public void setSponsors(List<Sponsor> sponsors) {
        this.sponsors = sponsors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return Objects.equals(cnpj, school.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnpj);
    }
}
