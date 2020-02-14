package com.project.schoolsystem.model.old;

import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.util.List;

@MappedSuperclass
public class User extends AbstractEntity {
    private String username;
    private String password;
    @Transient
    private String passwordConfirm;
    @ManyToMany
    private List<Role> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
