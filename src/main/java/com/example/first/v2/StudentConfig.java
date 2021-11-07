package com.example.first.v2;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import com.example.first.v2.model.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student zoro = new Student("ZORO", "...", LocalDate.of(2000, Month.NOVEMBER, 23));
            Student luffy = new Student("LUFFY", "...", LocalDate.of(2000, Month.NOVEMBER, 23));
            repository.saveAll(List.of(zoro, luffy));
        };
    }

}
