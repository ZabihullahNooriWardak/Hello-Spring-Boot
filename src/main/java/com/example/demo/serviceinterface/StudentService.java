package com.example.demo.serviceinterface;

import java.util.List;
import com.example.demo.entity.Student;

public interface StudentService {

    Student create(Student student);

    Student get(Long id);

    Student update(Student studentDetails);

    void delete(Long id);

    List<Student> getAll();
    
    boolean existsById(Long id);
}
