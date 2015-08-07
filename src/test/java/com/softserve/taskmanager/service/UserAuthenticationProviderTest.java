package com.softserve.taskmanager.service;

import com.softServe.taskManager.model.User;
import com.softServe.taskManager.service.UserService;
import com.softServe.taskManager.service.security.UserAuthenticationProvider;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class UserAuthenticationProviderTest {

    public static final String EMAIL = "email";
    public static final String PASSWORD = "123";
    @InjectMocks
    UserAuthenticationProvider userAuthenticationProvider;
    @Mock
    private UserService userService;
    @Mock
    private Authentication authentication;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test(expected = BadCredentialsException.class)
    public void testAuthenticateEmailEmpty() {
        userAuthenticationProvider.authenticate(authentication);
    }

    @Test(expected = BadCredentialsException.class)
    public void testAuthenticatePasswordEmpty() {
        when(authentication.getName()).thenReturn(EMAIL);
        userAuthenticationProvider.authenticate(authentication);
    }

    @Test(expected = BadCredentialsException.class)
    public void testAuthenticateNoUser() {
        when(authentication.getName()).thenReturn(EMAIL);
        when(authentication.getCredentials()).thenReturn(PASSWORD);
        userAuthenticationProvider.authenticate(authentication);
    }

    @Test(expected = BadCredentialsException.class)
    public void testAuthenticateWrongPassword() {
        User user = new User("mail", "1234", null);
        when(authentication.getName()).thenReturn(EMAIL);
        when(authentication.getCredentials()).thenReturn(PASSWORD);
        when(userService.findByEmail(EMAIL)).thenReturn(user);
        userAuthenticationProvider.authenticate(authentication);
    }

    @Test
    public void testAuthenticate() {
        User user = new User(EMAIL, String.valueOf(PASSWORD.hashCode()), null);
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(user, PASSWORD.hashCode(), null);
        when(authentication.getName()).thenReturn(EMAIL);
        when(authentication.getCredentials()).thenReturn(PASSWORD);
        when(userService.findByEmail(EMAIL)).thenReturn(user);
        assertEquals(authenticationToken, userAuthenticationProvider.authenticate(authentication));
    }

}