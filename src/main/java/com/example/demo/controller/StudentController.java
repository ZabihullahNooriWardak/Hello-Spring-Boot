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
import com.example.demo.serviceimp.StudentImp;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private final StudentImp studentService;
    private StudentRepository StudentRepository;

    public StudentController(StudentImp studentService) {

        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {

        return studentService.get(id);
    }

    @GetMapping
    public List<Student> getAllStudents() {

        return studentService.getAll();
    }

    @PostMapping
    public Student addStudent(@RequestBody @Valid Student student) {

        return studentService.create(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@RequestBody Student studentDetails) {

        if (StudentRepository.existsById(studentDetails.getId())) {
            return studentService.update(studentDetails);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deletestudent(@PathVariable Long id) {

        studentService.delete(id);
    }

}
