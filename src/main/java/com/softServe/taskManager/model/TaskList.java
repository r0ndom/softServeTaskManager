package com.softServe.taskManager.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@Entity
public class TaskList extends AbstractPersistenceObject{

    public static final int PRIMARY_LENGTH = 50;

    @NotEmpty
    @Length(max = PRIMARY_LENGTH)
    @Column
    private String name;
    @Column
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "TASK_LIST",
            joinColumns = @JoinColumn(name = "taskList_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id")
    )
    private List<Task> tasks;

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
}
