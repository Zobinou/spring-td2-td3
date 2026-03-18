package com.hei.springtd.controller;

import com.hei.springtd.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {

    private static List<Student> students = new ArrayList<>();

    @PostMapping("/students")
    public List<Student> addStudents(@RequestBody List<Student> newStudents) {
        students.addAll(newStudents);
        return students;
    }

    @GetMapping("/students")
    public String getStudents(@RequestHeader("Accept") String accept) {
        if (accept.equals("text/plain")) {
            return students.stream()
                    .map(s -> s.getFirstName() + " " + s.getLastName())
                    .collect(Collectors.joining(", "));
        } else {
            return "Format non supporté";
        }
    }
}