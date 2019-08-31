package com.aayojak;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.aayojak.security.MyPasswordEncoder;

public class Test {

    public static void main(String[] args) {
        MyPasswordEncoder mpe = new MyPasswordEncoder();
        PasswordEncoder pe = mpe.passwordEncoder();
        System.out.println(pe.encode("Sailpoint123"));
        
        Object o = "00gjmzgoxnydWGs740h7";
     String s1 =(String) o;
     System.out.println(s1.equals("00gjmzgoxnydWGs740h7"));
        
        
        

    }

}
