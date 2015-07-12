package com.softServe.taskManager.service.security;

import com.softServe.taskManager.model.User;
import com.softServe.taskManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class UserAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    /**
     * Performs authentication
     * @param authentication - the authentication request object.
     * @return a fully authenticated object including credentials
     */
    @Override
    public Authentication authenticate(final Authentication authentication) {
        final String username = authentication.getName();
        final String password = (String) authentication.getCredentials();

        if (username == null || username.trim().isEmpty()) {
            throw new BadCredentialsException("Email cannot be empty");
        }

        if (password == null || password.trim().isEmpty()) {
            throw new BadCredentialsException("Password cannot be empty");
        }

        final User user = userService.findByEmail(username);

        if (user == null) {
            throw new BadCredentialsException("Username not found.");
        }

        if (password.hashCode() != Integer.parseInt(user.getPassword())) {
            throw new BadCredentialsException("Wrong password.");
        }

        return new UsernamePasswordAuthenticationToken(user, password.hashCode(),
                null);
    }

    /**
     * Check if AuthenticationProvider supports the indicated Authentication object.
     * @param aClass - the authentication object.
     * @return true if supporting
     */
    @Override
    public boolean supports(final Class<?> aClass) {
        return true;
    }
}
