package com.hei.springtd;

import com.hei.springtd.model.Student;
import com.hei.springtd.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;

@SpringBootApplication
public class SpringTdApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringTdApplication.class, args);
    }


    @Bean
    public CommandLineRunner initData(StudentService studentService) {
        return args -> {
            Student s1 = new Student();
            s1.setReference("STD24001");
            s1.setPrenom("Jessica");
            s1.setNom("Dupont");

            Student s2 = new Student();
            s2.setReference("STD24003");
            s2.setPrenom("Liantsoa ");
            s2.setNom("Ramaharison");

            studentService.saveAll(List.of(s1, s2));
        };
    }
}
