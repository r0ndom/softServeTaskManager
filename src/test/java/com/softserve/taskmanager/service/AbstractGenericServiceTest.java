package com.softserve.taskmanager.service;

import com.softServe.taskManager.dao.GenericDao;
import com.softServe.taskManager.model.AbstractPersistenceObject;
import com.softServe.taskManager.service.GenericService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:mvc-service-test.xml")
public abstract class AbstractGenericServiceTest {

    public static final Long ID = 1L;

    private GenericDao<AbstractPersistenceObject> genericDao;
    private GenericService<AbstractPersistenceObject> genericService;

    private AbstractPersistenceObject testEntity;

    protected abstract GenericService getGenericService();
    protected abstract GenericDao<AbstractPersistenceObject> getGenericDao();
    protected abstract AbstractPersistenceObject getTestEntity();

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        genericDao = getGenericDao();
        testEntity = getTestEntity();
        genericService = getGenericService();
    }

    @After
    public void tearDown(){
        testEntity = null;
        genericDao = null;
        genericDao = getGenericDao();
        genericService = null;
    }


    @Test
    public void testDeleteByCode() {
        doAnswer(new Answer() {
            @Override
            public Object answer(final InvocationOnMock invocation) throws Throwable {
                testEntity = null;
                return null;
            }
        }).when(genericDao).delete(ID);
        genericService.delete(ID);
        assertEquals(testEntity, null);
        testEntity = getTestEntity();
    }

    @Test
    public void testFind() {
        when(genericDao.find(ID)).thenReturn(testEntity);
        assertEquals(testEntity, genericService.find(ID));
    }

    @Test
    public void testCreate() {
        when(genericDao.create(testEntity)).thenReturn(testEntity);
        assertEquals(testEntity, genericService.create(testEntity));
    }

    @Test
    public void testUpdate() {
        when(genericDao.update(testEntity)).thenReturn(testEntity);
        assertEquals(testEntity, genericService.update(testEntity));
    }

    @Test
    public void testFindAll() {
        when(genericDao.findAll()).thenReturn(Arrays.asList(testEntity));
        assertEquals(Arrays.asList(testEntity), genericService.findAll());
    }
}
