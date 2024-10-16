package com.example.demo.serviceimp;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.serviceinterface.StudentService;

@Service
public class StudentImp implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student create(Student student) {

        return studentRepository.save(student);
    }

    @Override
    public Student get(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.get();
    }

    @Override
    public Student update(Student studentDetails) {

        return studentRepository.save(studentDetails);
    }

    @Override
    public void delete(Long id) {

        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getAll() {
        List<Student> students = studentRepository.findAll();
        return students;
    }

}
