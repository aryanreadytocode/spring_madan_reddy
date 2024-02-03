package com.example.main;

import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;
import java.util.function.Supplier;

public class Example7 {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var volkswagen = new Vehicle();
        volkswagen.setName("Volkswagen");
        Supplier<Vehicle> volkswagenSupplier = () -> volkswagen;

        Supplier<Vehicle> audiSupplier = () -> {
            Vehicle audi = new Vehicle();
            audi.setName("Audi");
            return audi;
        };

        Random random = new Random();
        int randomNumber = random.nextInt(10);
        System.out.println("randomNumber = "+randomNumber);

        if (randomNumber % 2 == 0) {
            context.registerBean("audi", Vehicle.class, audiSupplier);
        }else {
            context.registerBean("volkswagen", Vehicle.class, volkswagenSupplier);
        }
        Vehicle volksVehicle = null;
        Vehicle audiVehicle = null;


        try {
            volksVehicle = context.getBean("volkswagen", Vehicle.class);
            System.out.println(volksVehicle.getName());
        }catch (NoSuchBeanDefinitionException noSuchBeanDefinitionException) {
            System.out.println("Error while creating Volkswagen vehicle");
        }
        try {
            audiVehicle = context.getBean("audi", Vehicle.class);
            System.out.println(audiVehicle.getName());
        }catch (NoSuchBeanDefinitionException noSuchBeanDefinitionException) {
            System.out.println("Error while creating Audi vehicle");
        }
    }
}
