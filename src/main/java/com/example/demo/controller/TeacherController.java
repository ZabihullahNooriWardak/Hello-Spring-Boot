package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Teacher;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.demo.serviceinterface.TeacherService;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public ResponseEntity<List<Teacher>> getAll() {
        List<Teacher> teachers = teacherService.getAll();
        return ResponseEntity.ok(teachers);
    }

    @PostMapping
    public ResponseEntity<Teacher> create(@RequestBody Teacher teacher) {
        Teacher newTeacher = teacherService.create(teacher);
        return ResponseEntity.ok(newTeacher);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Teacher> update(@PathVariable Long id, @RequestBody Teacher teacherDetails) {
        // return new ResponseEntity<>(updatedTeacher, HttpStatus.OK);
        if (id.equals(teacherDetails.getId()) && teacherService.existsById(id)) {
            Teacher updatedTeacher = teacherService.update(teacherDetails);
            return ResponseEntity.status(HttpStatus.OK).body(updatedTeacher);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> get(@PathVariable Long id) {
        // return new ResponseEntity<>(teacher, HttpStatus.OK);
        if (teacherService.existsById(id)) {
            Teacher teacher = teacherService.get(id);
            return ResponseEntity.status(HttpStatus.OK).body(teacher);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (teacherService.existsById(id)) {
            teacherService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
