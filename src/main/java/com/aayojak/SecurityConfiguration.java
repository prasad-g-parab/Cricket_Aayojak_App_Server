package com.aayojak;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.aayojak.security.CustomUsernamePasswordAuthenticationFilter;

@EnableWebSecurity // The @EnableWebSecurity is a marker annotation. It allows Spring to find and
                   // automatically apply the class to the global WebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;
    
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationSuccessHandler successHandler;

    @Autowired
    private AuthenticationFailureHandler failureHandler;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().and().formLogin().loginProcessingUrl("/api/common/login").usernameParameter("mobile").passwordParameter("password");
        http.authorizeRequests()
        .antMatchers("/api/player/**").access("hasRole('PLAYER')")
        .antMatchers("/api/team/**").access("hasRole('TEAM')")
        .antMatchers("/api/admin/**").access("hasRole('ADMIN')")
        .antMatchers("api/common/**").anonymous();
 
        http.csrf().disable();
        http.cors().disable();
        http.cors().and();
        http.addFilterBefore(authenticationFilter(), UsernamePasswordAuthenticationFilter.class);
      
    }
    
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
    
    public CustomUsernamePasswordAuthenticationFilter authenticationFilter() throws Exception {
        CustomUsernamePasswordAuthenticationFilter filter = new CustomUsernamePasswordAuthenticationFilter();
        filter.setAuthenticationManager(authenticationManagerBean());
        filter.setFilterProcessesUrl("/api/common/login");
        filter.setUsernameParameter("mobile");
        filter.setPasswordParameter("password");
        filter.setAuthenticationSuccessHandler(successHandler);
        filter.setAuthenticationFailureHandler(failureHandler);

        return filter;
    }
    
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }



}



/**
 * Imp Links : https://spring.io/guides/gs/securing-web/
 */