package com.epam.maksym_yena.java.lesson_18.task_10.service;

import java.util.List;

import com.epam.maksym_yena.java.lesson_18.task_10.dao.HospitalDAO;
import com.epam.maksym_yena.java.lesson_18.task_10.entity.Booking;
import com.epam.maksym_yena.java.lesson_18.task_10.entity.Doctor;
import com.epam.maksym_yena.java.lesson_18.task_10.entity.Status;
import org.springframework.stereotype.Component;

@Component
public class BookingDoctorService
{
    private HospitalDAO doctorsDAO = new HospitalDAO();

    public List<Booking> get()
    {
        return doctorsDAO.get();
    }

    public Doctor get(long id)
    {
        return doctorsDAO.get(id);
    }

    public Booking get(String name, Integer  time) {
        return doctorsDAO.findDoctor(time, name, doctorsDAO.bookingsList);
    }

    public Booking create(String doctor, Integer time)
    {
        return doctorsDAO.add(doctor,time);
    }

    public boolean delete(long id)
    {
        return doctorsDAO.delete(id);
    }
}
