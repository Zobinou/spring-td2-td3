package com.hei.springtd.service;

import com.hei.springtd.model.Student;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final List<Student> studentsInMemory = new ArrayList<>();

    public void saveAll(List<Student> students) {
        studentsInMemory.addAll(students);
    }

    public List<Student> getAll() {
        return studentsInMemory;
    }
}