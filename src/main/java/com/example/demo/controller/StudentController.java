package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.serviceimp.studentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private final studentService studentService;

    public StudentController(studentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@RequestBody Student studentDetails) {

        if (studentService.getStudentById(studentDetails.getId()).getId().equals(studentDetails.getId())) {
            return studentService.updateStudent(studentDetails);
        }
        return null;
    }

    @DeleteMapping("/{id}")

    public void deletestudent(@PathVariable Long id) {

        if (studentService.getStudentById(id).getId().equals(id)) {

            studentService.deleteStudent(id);
        }

    }

}
