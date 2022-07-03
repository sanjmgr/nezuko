package com.sanjmgr.nezuko.entity;

import com.sanjmgr.nezuko.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student sanjay = new Student(1L, "Sanjay", "Magar", 24, LocalDate.of(1997, Month.AUGUST, 17), "sanjmgr@gmail.com");
            Student nisan = new Student(2L, "Nisan", "Chhetri", 25, LocalDate.of(1996, Month.JANUARY, 20), "nisanchhetri@gmail.com");

            repository.saveAll(List.of(sanjay, nisan));
        };
    }
}
