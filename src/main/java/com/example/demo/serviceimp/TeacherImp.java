package com.example.demo.serviceimp;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Teacher;
import com.example.demo.repository.TeacherRepository;
import com.example.demo.serviceinterface.TeacherService;

@Service
public class TeacherImp implements TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    public TeacherImp(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher get(Long id) {

        Optional<Teacher> teacher = teacherRepository.findById(id);
        return teacher.get();
    }

    @Override
    public List<Teacher> getAll() {

        List<Teacher> teachers = teacherRepository.findAll();
        return teachers;
    }

    @Override
    public Teacher create(Teacher teacher) {

        Teacher savedTeacher = teacherRepository.save(teacher);
        return savedTeacher;
    }

    @Override
    public Teacher update(Teacher teacherDetails) {

        return teacherRepository.save(teacherDetails);
    }

    @Override
    public void delete(Long id) {

        teacherRepository.deleteById(id);
    }

}
