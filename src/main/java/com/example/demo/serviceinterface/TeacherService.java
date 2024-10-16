package com.example.demo.serviceinterface;

import java.util.List;
import com.example.demo.entity.Teacher;

public interface TeacherService {

    public Teacher getTeacherById(Long id);

    public List<Teacher> getAllTeachers();

    public Teacher addTeacher(Teacher teacher);

    public Teacher updateTeacher(Teacher teacherdetails);

    public void deleteTeacher(Long id);

}
