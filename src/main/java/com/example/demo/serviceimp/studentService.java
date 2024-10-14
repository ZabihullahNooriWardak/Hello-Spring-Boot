package com.example.demo.serviceimp;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

import com.example.demo.serviceinterface.studentServiceInterface;

@Service

public class studentService implements studentServiceInterface {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public ResponseEntity<Student> addStudent(Student student) {

        Student student1 = studentRepository.save(student);
        return ResponseEntity.ok(student1);

    }

    @Override
    public ResponseEntity<Student> getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return ResponseEntity.ok(student.get());
        } else {
            return ResponseEntity.ok(null);
        }
    }

    @Override
    public ResponseEntity<Student> updateStudent(Long id, Student studentDetails) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            Student student1 = student.get();
            student1.setName(studentDetails.getName());
            student1.setEmail(studentDetails.getEmail());
            student1.setTeacher(studentDetails.getTeacher());
            Student updatedStudent = studentRepository.save(student1);
            return ResponseEntity.ok(updatedStudent);
        } else {
            return ResponseEntity.ok(null);
        }
    }

    @Override
    public ResponseEntity<Student> deleteStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            studentRepository.delete(student.get());
            return ResponseEntity.ok(student.get());
        } else {
            return ResponseEntity.ok(null);
        }
    }

    @Override
    public ResponseEntity getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return ResponseEntity.ok(students);
    }

}
