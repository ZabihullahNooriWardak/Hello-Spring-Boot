package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Teacher;
import com.example.demo.serviceimp.TeacherImp;
import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private final TeacherImp teacherService;

    public TeacherController(TeacherImp teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<Teacher> getAllTeacher() {
        return teacherService.getAllTeachers();
    }

    @PostMapping
    public Teacher postTeacher(@RequestBody Teacher teacher) {
        return teacherService.addTeacher(teacher);
    }

    @PutMapping("/{id}")
    public Teacher updateTeacher(@RequestBody Teacher teacherDetails) {
        return teacherService.updateTeacher(teacherDetails);
    }

    @GetMapping("/{id}")
    public Teacher getTeacher(@PathVariable Long id) {
        return teacherService.getTeacherById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id) {

        teacherService.deleteTeacher(id);
    }
}
