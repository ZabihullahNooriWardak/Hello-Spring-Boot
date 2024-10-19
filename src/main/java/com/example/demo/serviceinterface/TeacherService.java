package com.example.demo.serviceinterface;

import java.util.List;
import com.example.demo.entity.Teacher;

public interface TeacherService {

    public Teacher get(Long id);

    public List<Teacher> getAll();

    public Teacher create(Teacher teacher);

    public Teacher update(Teacher teacherdetails);

    public void delete(Long id);

    public boolean existsById(Long id);

}
