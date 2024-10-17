package com.example.demo.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Student;
import com.example.demo.serviceimp.StudentImpl;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentImpl studentService;

    public StudentController(StudentImpl studentService) {

        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> get(@PathVariable Long id) {

        Student student = studentService.get(id);
        if (student != null) {
            return ResponseEntity.ok().body(student);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAll() {

        List<Student> students = studentService.getAll();
        if (students != null) {
            return ResponseEntity.ok().body(students);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@RequestBody Student studentDetails) {
        Student checkStudent = studentService.get(studentDetails.getId());
        if (checkStudent != null) {
            Student updateStudent = studentService.update(studentDetails);
            return ResponseEntity.ok(updateStudent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody @Valid Student student) {

        Student savedStudent = studentService.create(student);
        if (savedStudent != null) {

            // return ResponseEntity.ok().body(savedStudent);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> delete(@PathVariable Long id) {
        if (studentService.get(id) != null) {

            studentService.delete(id);
            return ResponseEntity.noContent().build();
        } else {

            return ResponseEntity.notFound().build();
        }
    }

}
