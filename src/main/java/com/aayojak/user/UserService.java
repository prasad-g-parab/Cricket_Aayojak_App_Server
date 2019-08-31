package com.aayojak.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserDetails findUserByMobileAndRole(String mobile, String role) {

        return userRepository.findDistinctByMobileAndRole(mobile, role);
    }

}
