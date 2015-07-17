//package com.softserve.taskmanager.controller;
//
//import com.softServe.taskManager.controller.LoginController;
//import com.softServe.taskManager.controller.RegisterController;
//import com.softServe.taskManager.model.User;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.MockitoAnnotations;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:mvc-test.xml")
//public class LoginControllerTest {
//
//    @InjectMocks
//    private LoginController loginController;
//    private MockMvc mockMvc;
//
//
//    @Before
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//        this.mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
//    }
//
//    @Test
//    public void loginPageTest () throws Exception{
//        mockMvc.perform(get("/login}"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("/login/login"));
//    }
//
//
//}
