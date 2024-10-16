package com.example.demo.serviceimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.serviceinterface.studentServiceInterface;

@Service

public class studentService implements studentServiceInterface {

    @Autowired
   private  StudentRepository studentRepository;

    @Override
    public Student addStudent(Student student) {

        return studentRepository.save(student);

    }

    @Override
    public Student getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.get();
    }

    @Override
    public Student updateStudent(Student studentDetails) {
       
        Student updatedStudent = studentRepository.save(studentDetails);
        return updatedStudent;

    }

    @Override
    public void deleteStudent(Student student) {
        studentRepository.delete(student);

    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students;
    }

}
