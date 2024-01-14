package com.shahidul.dev.simplecrud.services.impl;

import com.shahidul.dev.simplecrud.dto.StudentDTO;
import com.shahidul.dev.simplecrud.entities.Student;
import com.shahidul.dev.simplecrud.exceptions.RecourceNotFound;
import com.shahidul.dev.simplecrud.mapper.StudentMapper;
import com.shahidul.dev.simplecrud.ripositories.StudentRipository;
import com.shahidul.dev.simplecrud.services.StudentServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServicesImpl implements StudentServices {
    private StudentRipository studentRipository;
    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = StudentMapper.mapToStudent(studentDTO);
        Student savedStudent = studentRipository.save(student);
        return StudentMapper.mapToStudentDTO(savedStudent);
    }

    @Override
    public StudentDTO getStudentById(Long studentId) {
       Student student = studentRipository.findById(studentId)
                .orElseThrow(() ->
                        new RecourceNotFound("Student is not exist with given id "+ studentId));
        return StudentMapper.mapToStudentDTO(student);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
       List<Student> students = studentRipository.findAll();
        return students.stream().map((student) -> StudentMapper.mapToStudentDTO(student))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO updateStudent(Long studentId, StudentDTO updatedStudent) {
        Student student = studentRipository.findById(studentId).orElseThrow(
                () -> new RecourceNotFound("Student is not exists with giver id "+studentId)
        );
        student.setFirstName(updatedStudent.getFirstName());
        student.setLastName(updatedStudent.getLastName());
        student.setEmail(updatedStudent.getEmail());
        Student updatedStudentObj = studentRipository.save(student);
        return StudentMapper.mapToStudentDTO(updatedStudentObj);
    }

    @Override
    public void deleteStudent(Long studentId) {
        Student student = studentRipository.findById(studentId).orElseThrow(
                () -> new RecourceNotFound("Student is not exists with giver id "+studentId)
        );
        studentRipository.deleteById(studentId);
    }
}
