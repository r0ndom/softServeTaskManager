package com.softServe.taskManager.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Task extends AbstractPersistenceObject{

    public static final int PRIMARY_LENGTH = 64;

    @NotEmpty
    @Length(max = PRIMARY_LENGTH)
    @Column
    private String name;
    @Column
    @Temporal(TemporalType.DATE)
    private Date deadline;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "taskList_id")
    private TaskList taskList;

    public Task() {
    }

    public Task(String name, Date deadline, TaskList taskList) {
        this.name = name;
        this.deadline = deadline;
        this.taskList = taskList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public TaskList getTaskList() {
        return taskList;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }
}
