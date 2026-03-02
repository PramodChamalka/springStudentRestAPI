package com.pramod.student_management.controller;

import com.pramod.student_management.entity.Student;
import com.pramod.student_management.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/student/add")
    public void createStudent(@RequestBody Student student){
        repo.save(student);

    }

    @PutMapping("student/update/{id}")
    public Student updateStudent(@PathVariable int id){
        Student student = repo.findById(id).get();
        student.setName("Poornima");
        student.setPercentage(78);
        repo.save(student);
        return student;
    }

    @DeleteMapping("/student/delete/{id}")
    public void deleteStudent(@PathVariable int id){
        Student student=repo.findById(id).get();
        repo.delete(student);

    }
}
