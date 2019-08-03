package com.aayojak.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
   User findDistinctByMobileAndRole(String mobile, String role);
}


/** 
Imp Link: https://www.baeldung.com/the-persistence-layer-with-spring-data-jpa
**/