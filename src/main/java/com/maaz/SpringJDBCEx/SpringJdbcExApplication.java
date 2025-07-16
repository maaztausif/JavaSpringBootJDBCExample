package com.maaz.SpringJDBCEx;

import com.maaz.SpringJDBCEx.model.Student;
import com.maaz.SpringJDBCEx.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcExApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcExApplication.class, args);
		Student std = context.getBean(Student.class);
		std.setRollNo(1);
		std.setName("Maaz");
		std.setMarks(100);

		StudentService stdService = context.getBean(StudentService.class);
		stdService.addStudent(std);

		System.out.println("all data" + stdService.getStudent());

	}

}
