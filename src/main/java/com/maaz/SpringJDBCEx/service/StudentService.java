package com.maaz.SpringJDBCEx.service;

import com.maaz.SpringJDBCEx.model.Student;
import com.maaz.SpringJDBCEx.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository stdRepo;

    public StudentRepository getStdRepo() {
        return stdRepo;
    }

    @Autowired
    public void setStdRepo(StudentRepository stdRepo) {
        this.stdRepo = stdRepo;
    }


    public void addStudent(Student std){
        System.out.println("Student Added");
        System.out.println("name " + std.getName());
        stdRepo.save(std);
    }

    public List<Student> getStudent(){
        return stdRepo.findAll();
    }
}
