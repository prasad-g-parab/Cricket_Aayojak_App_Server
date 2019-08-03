package com.aayojak.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.aayojak.user.User;

@Component
public class CustomAuthenticationSuccessHandeller implements AuthenticationSuccessHandler{

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // set our response to OK status
        response.setStatus(HttpServletResponse.SC_OK);

        User employeeUserDetails = (User) authentication.getPrincipal();
        if (employeeUserDetails != null) {
            employeeUserDetails.setPassword("*****************");
        }

        SecurityUtils.sendResponse(response, HttpServletResponse.SC_OK, employeeUserDetails);

        
    }

}
