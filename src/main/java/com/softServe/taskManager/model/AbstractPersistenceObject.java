package com.softServe.taskManager.model;

import org.springframework.data.annotation.Id;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.UUID;

@MappedSuperclass
public abstract class AbstractPersistenceObject implements Serializable {

    private static final long SerialVersionUID = 1L;

    @Id
    @javax.persistence.Id
    private String id = UUID.randomUUID().toString();

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

}
