package com.example.first.v2;

import java.util.Optional;

import com.example.first.v2.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("student")
public interface StudentRepository extends JpaRepository<Student, Long> {
    
    // @Query("SELECT s from Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);

}
