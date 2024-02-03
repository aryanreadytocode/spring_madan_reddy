package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.ignoringRequestMatchers("/saveMsg"))
                .authorizeHttpRequests((requests) -> {
                    requests.requestMatchers("/dashboard").authenticated();
                    requests.requestMatchers("", "/", "/home").permitAll();
                    requests.requestMatchers("/holidays/**").permitAll();
                    requests.requestMatchers("/contact").permitAll();
                    requests.requestMatchers("/saveMsg").permitAll();
                    requests.requestMatchers("/courses").permitAll();
                    requests.requestMatchers("/about").permitAll();
                    requests.requestMatchers("/assets/**").permitAll();
                    requests.requestMatchers("/login").permitAll();
                    requests.requestMatchers("/logout").permitAll();
                })
                .formLogin(loginConfigurer -> loginConfigurer.loginPage("/login")
                        .defaultSuccessUrl("/dashboard")
                        .failureUrl("/login?error=true").permitAll()
                )
                .httpBasic(Customizer.withDefaults());
        return http.build();

        //Deny All Requests inside the Web Application
        /*http.authorizeHttpRequests((requests) -> requests.anyRequest().denyAll());
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();*/


    }

    @Bean
    public InMemoryUserDetailsManager userDetailService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("12345")
                .roles("USER")
                .build();

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("54321")
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}
