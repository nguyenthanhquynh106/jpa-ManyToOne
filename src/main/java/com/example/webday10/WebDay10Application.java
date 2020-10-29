package com.example.webday10;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.webday10.entity.Faculty;
import com.example.webday10.entity.Passport;
import com.example.webday10.entity.Student;
import com.example.webday10.service.FacultyService;

@SpringBootApplication
public class WebDay10Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(WebDay10Application.class, args);
		FacultyService facultyService = applicationContext.getBean(FacultyService.class);

		Passport p1 = new Passport();
		p1.setNumber("00A01");
		Student s1 = new Student();
		s1.setName("Nguyen Van A");
		s1.setPassport(p1);
		
		Passport p2 = new Passport();
		p2.setNumber("00A02");
		Student s2 = new Student();
		s2.setName("Tran Thi B");
		s2.setPassport(p2);

		Faculty f = new Faculty();
		f.setName("Information Technology");

		s1.setFaculty(f);
		s2.setFaculty(f);

		Set<Student> students = new HashSet<>();
		students.add(s1);
		students.add(s2);
		f.setStudents(students);

		facultyService.insert(f);
	}

}
