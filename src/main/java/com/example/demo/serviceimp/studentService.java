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
    private StudentRepository studentRepository;

    @Override
    public Student addStudent(Student student) {

        return studentRepository.save(student);

    }

    @Override
    public Student getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return student.get();
        } else {
            return null;
        }

    }

    @Override
    public Student updateStudent( Student studentDetails) {
        Optional<Student> student = studentRepository.findById(studentDetails.getId());
        if (student.isPresent()) {
            Student student1 = student.get();
            student1.setName(studentDetails.getName());
            student1.setEmail(studentDetails.getEmail());
            student1.setTeacher(studentDetails.getTeacher());
            Student updatedStudent = studentRepository.save(student1);
            return updatedStudent;
        } else {
            return null;
        }
    }

    @Override
    public void deleteStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        studentRepository.delete(student.get());
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students;
    }

}
