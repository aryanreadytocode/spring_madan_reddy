package com.example;

import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class AryanSchoolApplication {

	public static void main(String[] args) {
//		new AryanSchoolApplication().printMaxSalary();
		SpringApplication.run(AryanSchoolApplication.class, args);
	}

	/*private void printMaxSalary() {
		List<Emp> empList = new ArrayList<>();
		empList.add(new Emp(10000l, "Raj"));
		empList.add(new Emp(12000l, "Raja"));
		empList.add(new Emp(15000l, "Rajan"));
		empList.add(new Emp(20000l, "Rajnish"));
		empList.add(new Emp(20000l, "Aajnish"));
		empList.add(new Emp(20000l, "Zajnish"));

		Optional<Emp> val = empList.stream().filter(emp -> emp.name.charAt(0) == 'A').max(Comparator.comparing(emp -> emp.sal));
		System.out.println(val.get().toString());
	}*/

	/*@AllArgsConstructor
	@ToString
	public class Emp{
		private Long sal;
		private String name;
	}*/

}
