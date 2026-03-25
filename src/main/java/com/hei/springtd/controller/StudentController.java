package com.hei.springtd.controller;

import com.hei.springtd.exception.BadRequestException;
import com.hei.springtd.model.Student;
import com.hei.springtd.service.StudentService;
import com.hei.springtd.validator.StudentValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class StudentController {

    private final StudentValidator studentValidator;
    private final StudentService studentService;

    public StudentController(StudentValidator studentValidator,
                             StudentService studentService) {
        this.studentValidator = studentValidator;
        this.studentService   = studentService;
    }


    @GetMapping("/students")
    public ResponseEntity<?> getStudents() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(studentService.getAll());
    }


    @PostMapping("/students")
    public ResponseEntity<?> createStudents(
            @RequestBody List<Student> newStudents) {
        try {
            studentValidator.validate(newStudents);
            studentService.saveAll(newStudents);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .header("Content-Type", "application/json")
                    .body(studentService.getAll());

        } catch (BadRequestException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "text/plain")
                    .body(e.getMessage());
        }
    }
}

