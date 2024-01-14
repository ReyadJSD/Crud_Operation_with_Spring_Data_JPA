package com.shahidul.dev.simplecrud.mapper;

import com.shahidul.dev.simplecrud.dto.StudentDTO;
import com.shahidul.dev.simplecrud.entities.Student;

public class StudentMapper {
    public static StudentDTO mapToStudentDTO(Student s) {
        return new StudentDTO(
                s.getStudentId(),
                s.getFirstName(),
                s.getLastName(),
                s.getEmail()
        );
    }

    public static Student mapToStudent(StudentDTO sdto) {
        return new Student(
                sdto.getStudentId(),
                sdto.getFirstName(),
                sdto.getLastName(),
                sdto.getEmail()
        );
    }
}
