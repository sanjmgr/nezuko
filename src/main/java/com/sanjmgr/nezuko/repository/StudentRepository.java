package com.sanjmgr.nezuko.repository;

import com.sanjmgr.nezuko.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StudentRepository  extends JpaRepository<Student, Long> {

    @Query("select s from Student s where s.email = ?1")
    Optional<Student> searchStudentByEmail(String email);

}
