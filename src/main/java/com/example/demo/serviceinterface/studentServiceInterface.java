package com.example.demo.serviceinterface;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.entity.Student;

public interface studentServiceInterface {

ResponseEntity<Student> addStudent(Student student);

ResponseEntity<Student> getStudentById(Long id);

ResponseEntity<Student> updateStudent(Long id, Student studentDetails);

ResponseEntity<Student> deleteStudent(Long id);

ResponseEntity<List<Student>> getAllStudents();
    
} 