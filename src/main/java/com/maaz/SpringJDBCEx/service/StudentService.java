package com.maaz.SpringJDBCEx.service;

import com.maaz.SpringJDBCEx.model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public void addStudent(Student std){
        System.out.println("Student Added");
    }
}
