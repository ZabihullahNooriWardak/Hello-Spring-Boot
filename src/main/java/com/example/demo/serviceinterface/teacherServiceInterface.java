package com.example.demo.serviceinterface;

import java.util.List;

import com.example.demo.entity.Teacher;

public interface teacherServiceInterface {

    public Teacher addTeacher(Teacher teacher);

    public Teacher updateTeacher(Long id,Teacher teacherdetails);

    public void deleteTeacher(Long id);

    public List<Teacher> getAllTeachers();

    public Teacher getTeacherById(Long id);

}
