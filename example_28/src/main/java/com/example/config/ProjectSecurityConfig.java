package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        /*
        * /home
        * /holidays
        * /contact
        * /saveMsg
        * /courses
        * /about
        * */
        //Permit All Requests inside the Web Application
        http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests((requests) -> {
            requests.requestMatchers("", "/", "/home").permitAll();
            requests.requestMatchers("/holidays/**").permitAll();
            requests.requestMatchers("/contact").permitAll();
            requests.requestMatchers("/saveMsg").permitAll();
            requests.requestMatchers("/courses").permitAll();
            requests.requestMatchers("/about").permitAll();
            requests.requestMatchers("/assets/**").permitAll();
        });
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();

        //Deny All Requests inside the Web Application
        /*http.authorizeHttpRequests((requests) -> requests.anyRequest().denyAll());
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();*/


    }
}
