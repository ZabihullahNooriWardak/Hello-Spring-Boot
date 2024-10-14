package com.example.demo.serviceinterface;
import java.util.List;

import com.example.demo.entity.Student;

public interface studentServiceInterface {

Student addStudent(Student student);

Student getStudentById(Long id);

Student updateStudent(Student studentDetails);

void deleteStudent(Long id);

List<Student> getAllStudents();
    
} 