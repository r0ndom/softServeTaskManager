package com.softServe.taskManager.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

@Entity
public class User extends AbstractPersistenceObject{

    public static final int PRIMARY_LENGTH = 64;

    @NotEmpty
    @Length(max = PRIMARY_LENGTH)
    @Column
    private String email;
    @NotEmpty
    @Length(max = PRIMARY_LENGTH)
    @Column
    private String password;
    @Column
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    //@JoinColumn(name = "id")
    private List<TaskList> lists;

    public User() {
    }

    public User(String email, String password, List<TaskList> lists) {
        this.email = email;
        this.password = password;
        this.lists = lists;
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

    public List<TaskList> getLists() {
        return lists;
    }

    public void setLists(List<TaskList> lists) {
        this.lists = lists;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!email.equals(user.email)) return false;
        if (lists != null ? !lists.equals(user.lists) : user.lists != null) return false;
        if (!password.equals(user.password)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = email.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + (lists != null ? lists.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getEmail();
    }
}
