package com.softServe.taskManager.service.impl;

import com.softServe.taskManager.dao.GenericDao;
import com.softServe.taskManager.model.AbstractPersistenceObject;
import com.softServe.taskManager.service.GenericService;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public abstract class AbstractGenericServiceImpl<T extends AbstractPersistenceObject> implements GenericService<T> {

    abstract protected GenericDao<T> getDao();

}
