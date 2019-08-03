package com.aayojak.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository UserRepository;

    public UserDetails findUserByMobileAndRole(String mobile, String role) {

        return UserRepository.findDistinctByMobileAndRole(mobile, role);
    }

}
