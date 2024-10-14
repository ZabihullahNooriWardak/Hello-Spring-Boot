package com.example.demo.serviceimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Teacher;
import com.example.demo.repository.TeacherRepository;
import com.example.demo.serviceinterface.teacherServiceInterface;

@Service
public class TeacherService implements teacherServiceInterface {

    @Autowired
    TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;

    }

    @Override
    public Teacher addTeacher(Teacher teacher) {
        Teacher savedTeacher = teacherRepository.save(teacher);
        return savedTeacher;
    }

    @Override
    public Teacher updateTeacher(Long id, Teacher teacherDetails) {

        return teacherRepository.findById(id).map(teacher -> {
            teacher.setName(teacherDetails.getName());
            teacher.setEmail(teacherDetails.getEmail());
            Teacher updateTeacher = teacherRepository.save(teacher);
            return updateTeacher;
        }).orElseGet(() -> null);
    }

    @Override
    public void deleteTeacher(Long id) {

        teacherRepository.deleteById(id);

    }

    @Override
    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers;
    }

    @Override
    public Teacher getTeacherById(Long id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        return teacher.get();
    }

}
