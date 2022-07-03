package com.sanjmgr.nezuko.services;

import com.sanjmgr.nezuko.entity.Student;
import com.sanjmgr.nezuko.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> students() {
        return studentRepository.findAll();
    }

    public void create(Student student) {
        Optional<Student> studentOptional = studentRepository.searchStudentByEmail(student.getEmail());

        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }

        studentRepository.save(student);
    }

    public List<Student> remove(Long studentId) {
        boolean doesExists = studentRepository.existsById(studentId);
        if (!doesExists) {
            throw new IllegalStateException("Student with id " + studentId + " does not exists");
        }

        studentRepository.deleteById(studentId);
        return studentRepository.findAll();
    }

    @Transactional
    public void update(Long studentId, String firstname, String lastname, String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(() ->
                new IllegalStateException("student with id " + studentId + "does not exists"));

        if (firstname != null && firstname.length() > 0 && !Objects.equals(student.getFirstname(), firstname)) {
            student.setFirstname(firstname);
        }

        if (lastname != null && lastname.length() > 0 && !Objects.equals(student.getLastname(), lastname)) {
            student.setLastname(lastname);
        }
        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentOptional = studentRepository.searchStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }

    }
}