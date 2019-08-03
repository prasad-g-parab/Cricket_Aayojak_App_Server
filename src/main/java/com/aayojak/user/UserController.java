package com.aayojak.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/common")
public class UserController {

 
    @RequestMapping("/test")
    public String test() {
        return "success";
    }
}
