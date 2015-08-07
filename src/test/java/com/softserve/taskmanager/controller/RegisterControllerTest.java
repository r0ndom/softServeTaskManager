package com.softserve.taskmanager.controller;

import com.softServe.taskManager.controller.RegisterController;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:mvc-test.xml")
public class RegisterControllerTest {

    @InjectMocks
    private RegisterController registerController;
    @Mock
    private UserService userService;
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(registerController).build();
    }

    @Test
    public void showRegisterPageTest() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("register/register"));
    }

    @Test
    public void addUserTest() throws Exception {
        mockMvc.perform(post("/addNewUser").sessionAttr("user", new User()))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/login"));
    }

    @Test
    public void checkUserEmailTest() throws Exception {
        mockMvc.perform(get("/validate").param("email", ""))
                .andExpect(status().isOk());
    }
}
