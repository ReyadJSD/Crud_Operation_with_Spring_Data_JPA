package com.shahidul.dev.simplecrud.ripositories;

import com.shahidul.dev.simplecrud.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRipository extends JpaRepository<Student, Long> {
}
