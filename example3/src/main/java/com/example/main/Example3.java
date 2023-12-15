package com.example.main;

import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example3 {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var veh1 = context.getBean("audiVehicle", Vehicle.class);
        System.out.println("Vehicle name from Spring Context is: "+veh1.getName());

        var veh2 = context.getBean("mercedesVehicle", Vehicle.class);
        System.out.println("Vehicle name from Spring Context is: "+veh2.getName());

        var veh3 = context.getBean("rollsRoyceVehicle", Vehicle.class);
        System.out.println("Vehicle name from Spring Context is: "+veh3.getName());

    }
}
