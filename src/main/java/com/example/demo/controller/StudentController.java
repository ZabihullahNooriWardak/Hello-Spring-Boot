package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@RequestMapping("/students")
public class StudentController {
    
private final StudentRepository studentRepository;
public StudentController(StudentRepository studentRepository){
    this.studentRepository=studentRepository;
}
@PostMapping("/students")
public Student addStudent(@RequestBody Student student) {
  Student savedStudent =  studentRepository.save(student);
    
    return savedStudent;
}
@GetMapping
public ResponseEntity<List<Student>> getAllStudents() {
    List<Student> students = studentRepository.findAll();
    return new ResponseEntity<>(students,HttpStatus.OK);
}



}
