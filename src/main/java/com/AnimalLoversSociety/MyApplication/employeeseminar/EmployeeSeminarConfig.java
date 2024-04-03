package com.AnimalLoversSociety.MyApplication.employeeseminar;

import com.AnimalLoversSociety.MyApplication.customers.CustomerRepository;
import com.AnimalLoversSociety.MyApplication.employees.Employees;
import com.AnimalLoversSociety.MyApplication.employees.EmployeesRepository;
import com.AnimalLoversSociety.MyApplication.items.ItemsRepository;
import com.AnimalLoversSociety.MyApplication.sales.SaleRepository;
import com.AnimalLoversSociety.MyApplication.seminars.Seminar;
import com.AnimalLoversSociety.MyApplication.seminars.SeminarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cglib.core.Local;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;

// This class adds sample data to the database
@Configuration
public class EmployeeSeminarConfig {
    @Bean
    CommandLineRunner runner(EmployeeSeminarRepository employeeSeminarRepository, EmployeesRepository employeesRepository, SeminarRepository seminarRepository) {
        return args -> {
            EmployeeSeminar attendance = new EmployeeSeminar();
            if (employeesRepository.findById(1).isEmpty()) {
                Employees employee = new Employees(
                        100,
                        "David Johnson",
                        "Accountant",
                        60000,
                        "Finance",
                        "Eric Williams",
                        "AGOC");
                employeesRepository.save(employee);
                attendance.setEmployee(employee);
            }

            Seminar seminar = new Seminar(
                    "Dog Training",
                    LocalDate.parse("2024-05-24"),
                    LocalTime.parse("10:00"),
                    "Shelter",
                    20,
                    0);
            if (seminarRepository.findByTitle("Dog Training").isEmpty()) {
                seminarRepository.save(seminar);
                attendance.setSeminar(seminar);
                employeeSeminarRepository.save(attendance);
            }
        };
    }
}
