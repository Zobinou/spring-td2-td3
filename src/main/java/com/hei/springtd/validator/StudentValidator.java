package com.hei.springtd.validator;

import com.hei.springtd.exception.BadRequestException;
import com.hei.springtd.model.Student;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class StudentValidator {

    public void validate(List<Student> students) {
        for (Student student : students) {
            if (student.getReference() == null
                    || student.getReference().isBlank()) {
                throw new BadRequestException(
                        "NewStudent.reference cannot be null");
            }
            if (student.getPrenom() == null
                    || student.getPrenom().isBlank()) {
                throw new BadRequestException(
                        "NewStudent.prenom cannot be null");
            }
            if (student.getNom() == null
                    || student.getNom().isBlank()) {
                throw new BadRequestException(
                        "NewStudent.nom cannot be null");
            }
        }
    }
}