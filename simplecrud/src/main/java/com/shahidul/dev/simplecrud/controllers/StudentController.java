package com.shahidul.dev.simplecrud.controllers;

import com.shahidul.dev.simplecrud.dto.StudentDTO;
import com.shahidul.dev.simplecrud.entities.Student;
import com.shahidul.dev.simplecrud.services.StudentServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentServices studentServices;

    //Create a Rest API to Add Students
    @PostMapping
    public ResponseEntity<StudentDTO> createStudents(@RequestBody StudentDTO studentDTO){
        StudentDTO savedStudents = studentServices.createStudent(studentDTO);
        return new ResponseEntity<>(savedStudents, HttpStatus.CREATED);
    }

    //Get Student By Id Method
    @GetMapping("{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable("id") Long studentId){
        StudentDTO getStudents = studentServices.getStudentById(studentId);
        return ResponseEntity.ok(getStudents);
    }

    //Get All Students Method
    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents(){
        List<StudentDTO> studentDTOS = studentServices.getAllStudents();
        return ResponseEntity.ok(studentDTOS);
    }

    //Update Student Method
    @PutMapping("{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable("id") Long studentId, @RequestBody StudentDTO updatedStudent){
       StudentDTO studentDTO = studentServices.updateStudent(studentId, updatedStudent);
       return ResponseEntity.ok(studentDTO);
    }

    // Delete Student Rest API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long studentId){
        studentServices.deleteStudent(studentId);
        return ResponseEntity.ok("Student deleted successfully");
    }
}
