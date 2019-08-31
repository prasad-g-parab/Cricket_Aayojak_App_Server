package com.aayojak.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.aayojak.user.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;
    @Autowired
    private HttpServletRequest request;
    
    @Autowired
    ObjectMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     
        String role = (String) request.getSession().getAttribute("role");
        UserDetails user = userService.findUserByMobileAndRole(username, role);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid Credentials");
        }

        return user;
    }

}
