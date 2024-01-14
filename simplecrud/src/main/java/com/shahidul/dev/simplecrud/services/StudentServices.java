package com.shahidul.dev.simplecrud.services;

import com.shahidul.dev.simplecrud.dto.StudentDTO;

import java.util.List;

public interface StudentServices {
    StudentDTO createStudent(StudentDTO studentDTO);

    StudentDTO getStudentById(Long studentId);

    List<StudentDTO> getAllStudents();

    StudentDTO updateStudent(Long studentId, StudentDTO updatedStudent);

    void deleteStudent(Long studentId);
}
