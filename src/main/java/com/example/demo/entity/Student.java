package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "students")
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Email
    private String email;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    public Student() {
    }

    public Student(String name, String email, Teacher teacher) {
        this.name = name;
        this.email = email;
        this.teacher = teacher;
    }

}
