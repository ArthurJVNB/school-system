package com.project.schoolsystem.model.old;

import javax.persistence.*;
import java.util.List;

@Entity(name = "role")
public class Role extends AbstractEntity {
    private String name;
    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
