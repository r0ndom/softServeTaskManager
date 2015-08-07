package com.softServe.taskManager.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends AbstractPersistenceObject{

    public static final int PRIMARY_LENGTH = 64;

    @NotEmpty
    @Length(max = PRIMARY_LENGTH)
    private String email;
    @NotEmpty
    @Length(max = PRIMARY_LENGTH)
    private String password;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private List<Task> tasks;

    public User() {
    }

    public User(String email, String password, List<Task> tasks) {
        this.email = email;
        this.password = password;
        this.tasks = tasks;
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

    public List<Task> getTasks() {
        return tasks != null ? tasks : new ArrayList<Task>();
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return getEmail();
    }
}
