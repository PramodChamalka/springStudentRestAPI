package com.pramod.student_management.controller;

import com.pramod.student_management.entity.Student;
import com.pramod.student_management.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class StudentController {


    @Autowired
     StudentRepo repo;
    //get all students
    //localhost:8080/students
    @GetMapping("/students")
    public List<Student> getAllStudents(){

        List<Student> students=repo.findAll();
        return students;
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id){
        Student student = repo.findById(id).get();
        return student;
    }
}
