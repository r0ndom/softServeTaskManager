package com.softserve.taskmanager.controller;

import com.softServe.taskManager.controller.RegisterController;
import com.softServe.taskManager.controller.TaskListController;
import com.softServe.taskManager.model.TaskList;
import com.softServe.taskManager.model.User;
import com.softServe.taskManager.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:mvc-test.xml")
public class TaskListControllerTest {
    @InjectMocks
    private TaskListController taskListController;
    @Mock
    private UserService userService;
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(taskListController).build();
    }

    @Test
    public void showListTest() throws Exception {
        User user = new User();
        user.setLists(new ArrayList<TaskList>());
        when(userService.getCurrentUser()).thenReturn(user);
        mockMvc.perform(get("/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("list/list"))
                .andExpect(model().attributeExists("listArray"));
    }
}
