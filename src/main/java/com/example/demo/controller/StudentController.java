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
import com.example.demo.repository.StudentRepository;
import com.example.demo.serviceimp.StudentService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private final StudentService studentService;
    private StudentRepository StudentRepository;

    public StudentController(StudentService studentService) {

        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {

        return studentService.getStudentById(id);
    }

    @GetMapping
    public List<Student> getAllStudents() {

        return studentService.getAllStudents();
    }

    @PostMapping
    public Student addStudent(@RequestBody @Valid Student student) {

        return studentService.addStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@RequestBody Student studentDetails) {

        if (StudentRepository.existsById(studentDetails.getId())) {
            return studentService.updateStudent(studentDetails);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deletestudent(@PathVariable Long id) {

        studentService.deleteStudent(id);
    }

}
