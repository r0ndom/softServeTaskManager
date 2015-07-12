package com.softServe.taskManager.model;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Document
@Entity
public class User extends AbstractPersistenceObject{

    public static final int PRIMARY_LENGTH = 50;

    @NotEmpty
    @Length(max = PRIMARY_LENGTH)
    @Column
    private String email;
    @NotEmpty
    @Length(max = PRIMARY_LENGTH)
    @Column
    private String password;
    @Column
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
            name = "USER_LIST",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "taskList_id")
    )

//    @ElementCollection(fetch = FetchType.EAGER)
//    @CollectionTable(name = "UserProgLanguages",
//            joinColumns = @JoinColumn(name = "user_id"))
//    @ForExport("Programming Languages")
//    @Fetch(FetchMode.SELECT)
//    @BatchSize(size = 1)
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
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", lists=" + lists +
                '}';
    }
}
