package com.example.demo.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import com.example.demo.serviceinterface.StudentService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {
    // Bad way of Doing thing
    // private final StudentImpl studentService;

    private final StudentService studentService;

    public StudentController(StudentImpl studentService) {

        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> get(@PathVariable Long id) {
        if (studentService.existsById(id)) {
            Student student = studentService.get(id);
            return ResponseEntity.status(HttpStatus.OK).body(student);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

    }

    @GetMapping
    public ResponseEntity<Page<Student>> getAll(Pageable pageable) {
        Page<Student> students = studentService.getAll(pageable);
        return ResponseEntity.status(HttpStatus.CREATED).body(students);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@RequestBody Student studentDetails) {
        if (studentService.existsById(studentDetails.getId())) {
            Student updateStudent = studentService.update(studentDetails);
            return ResponseEntity.status(HttpStatus.OK).body(updateStudent);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody @Valid Student student) {
        Student savedStudent = studentService.create(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> delete(@PathVariable Long id) {
        if (studentService.existsById(id)) {
            studentService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
