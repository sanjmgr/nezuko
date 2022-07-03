package com.sanjmgr.nezuko.controllers;

import com.sanjmgr.nezuko.entity.Student;
import com.sanjmgr.nezuko.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api")
public class StudentController {

    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/api/students")
    public List<Student> students() {
        return studentService.students();
    }

    @PostMapping("/api/create")
    public void create(@RequestBody Student student) {
        studentService.create(student);
    }

    @DeleteMapping(path = "api/{studentId}")
    public List<Student> remove(@PathVariable("studentId") Long studentId) {
        return studentService.remove(studentId);
    }

    @PutMapping(path = "api/{studentId}")
    public void update(@PathVariable("studentId") Long studentId,
                       @RequestParam(required = false) String firstname,
                       @RequestParam(required = false) String lastname,
                       @RequestParam(required = false) String email) {
        studentService.update(studentId, firstname, lastname, email);
    }
}
