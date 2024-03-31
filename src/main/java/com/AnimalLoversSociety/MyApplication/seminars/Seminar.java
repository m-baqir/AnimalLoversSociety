package com.AnimalLoversSociety.MyApplication.seminars;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "seminars")
public class Seminar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates id for seminarId
    private Integer seminarId;

    @Column(nullable = false)
    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime time;
    private String location;
    @Column(nullable = false)
    private int capacity;
    @Column(nullable = false)
    private int enrolled;

    // No-arg constructor
    public Seminar() {
    }

    // Constructor without id (will be auto-generated)
    public Seminar(String title,
                   LocalDate date,
                   LocalTime time,
                   String location,
                   int capacity,
                   int enrolled) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.location = location;
        this.capacity = capacity;
        this.enrolled = enrolled;
    }

    // Getters and setters
    public int getSeminarId() {
        return seminarId;
    }

    public void setSeminarId(int seminarId) {
        this.seminarId = seminarId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) { this.capacity = capacity; }

    public int getEnrolled() {
        return enrolled;
    }

    public void setEnrolled(int enrolled) {
        this.enrolled = enrolled;
    }

}
