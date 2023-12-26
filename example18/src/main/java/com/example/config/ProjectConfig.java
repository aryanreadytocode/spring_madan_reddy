package com.example.config;

import com.example.beans.Vehicle;
import org.springframework.context.annotation.*;

/*
* Spring @Configuration annotation is part of the spring core framework.
* Spring Configuration annotation indicates that the class has @Bean definition
* methods. So Spring container can process the class and generate Spring Beans
* to be used in the application.*/
@Configuration
@ComponentScan(basePackages = {"com.example.implementation", "com.example.services", "com.example.aspects"})
@ComponentScan(basePackageClasses = {com.example.beans.Vehicle.class, com.example.beans.Person.class})
@EnableAspectJAutoProxy
public class ProjectConfig {

}
