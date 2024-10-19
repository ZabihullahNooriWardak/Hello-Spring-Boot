package com.example.demo.serviceinterface;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.entity.Student;

public interface StudentService {

    Student create(Student student);

    Student get(Long id);

    Student update(Student studentDetails);

    void delete(Long id);

    Page<Student> getAll(Pageable pageable);

    boolean existsById(Long id);
}
