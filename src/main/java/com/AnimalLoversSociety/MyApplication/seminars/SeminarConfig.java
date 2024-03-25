package com.AnimalLoversSociety.MyApplication.seminars;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;

// This class adds sample data to the database
@Configuration
public class SeminarConfig {
    @Bean
    CommandLineRunner seminarRunner(SeminarRepository repository) {
        return args -> {
            // if condition prevents the same sample data being entered into the database every time the server is started
            if (repository.findByTitle("Animal Welfare").isEmpty()) {
                Seminar seminar1 = new Seminar(
                        "Animal Welfare",
                        LocalDate.parse("2024-05-05"),
                        LocalTime.parse("12:00"),
                        "Library",
                        25,
                        5
                );
                repository.save(seminar1);
            }

            if (repository.findByTitle("Trap Neuter Return Program").isEmpty()) {
                Seminar seminar2 = new Seminar(
                        "Trap Neuter Return Program",
                        LocalDate.parse("2024-06-20"),
                        LocalTime.parse("15:00"),
                        "Online",
                        50,
                        10
                );
                repository.save(seminar2);
            }
        };
    }
}
