package com.AnimalLoversSociety.MyApplication.seminars;

import com.AnimalLoversSociety.MyApplication.employees.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SeminarService {

    private final SeminarRepository seminarRepository;

    @Autowired
    public SeminarService(SeminarRepository seminarRepository) {
        this.seminarRepository = seminarRepository;
    }

    public List<Seminar> getSeminars() {
        return seminarRepository.findAll();
    }

    public Seminar saveSeminar(Seminar seminar) { return seminarRepository.save(seminar); }

    public void deleteSeminarById(Integer seminarId) {
        seminarRepository.deleteById(seminarId);
    }

    public Seminar getSeminarById(Integer seminarId) {
        return seminarRepository.findById(seminarId).get();
    }

    public void incrementEnrollment(Seminar seminar) {
        seminar.setEnrolled(seminar.getEnrolled() + 1);
    }

    public int getAvailability(Seminar seminar) {
        return seminar.getCapacity() - seminar.getEnrolled();
    }

    public boolean isFull(Seminar seminar) {
        return (seminar.getEnrolled() == seminar.getCapacity());
    }

    public LocalDate getTodaysDate() {
        return LocalDate.now();
    }
}
