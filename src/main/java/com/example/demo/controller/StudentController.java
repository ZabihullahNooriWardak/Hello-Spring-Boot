package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired

    
private final StudentRepository studentRepository;
public StudentController(StudentRepository studentRepository){
    this.studentRepository=studentRepository;
}
@PostMapping
public ResponseEntity<Student> addStudent(@RequestBody Student student) {
  Student savedStudent =  studentRepository.save(student);
    
    return new ResponseEntity<>(savedStudent,HttpStatus.CREATED);
}
@GetMapping
public ResponseEntity<List<Student>> getAllStudents() {
    List<Student> students = studentRepository.findAll();
    return new ResponseEntity<>(students,HttpStatus.OK);
}

@PutMapping("/{id}")
public ResponseEntity<Student> updateStudent(@PathVariable Long id,@RequestBody Student studentDetails ){
    return studentRepository.findById(id).map(student ->{
        student.setName(studentDetails.getName());
        student.setEmail(studentDetails.getEmail());
        Student updatestudent = studentRepository.save(student);
        return ResponseEntity.ok(updatestudent);
    }).orElseGet(()-> ResponseEntity.notFound().build());
}

@DeleteMapping("/{id}")

public ResponseEntity<Void> deletestudent(@PathVariable Long id){
    return studentRepository.findById(id).map(student->{
        studentRepository.delete(student);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }).orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
}

}
