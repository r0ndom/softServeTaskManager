package com.softServe.taskManager.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@Entity
public class TaskList extends AbstractPersistenceObject{

    public static final int PRIMARY_LENGTH = 32;

    @NotEmpty
    @Length(max = PRIMARY_LENGTH)
    @Column
    private String name;
    @Column
    @OneToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "TASK_LIST",
//            joinColumns = @JoinColumn(name = "taskList_id"),
//            inverseJoinColumns = @JoinColumn(name = "task_id")
//    )
    @JoinColumn(name = "id")
    private List<Task> tasks;

    //@Transient
    @ManyToOne
    private User user;

    public TaskList() {
    }

    public TaskList(String name, List<Task> tasks, User user) {
        this.name = name;
        this.tasks = tasks;
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
