package com.epam.maksym_yena.java.lesson_18.task_10.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.epam.maksym_yena.java.lesson_18.task_10.entity.Booking;
import com.epam.maksym_yena.java.lesson_18.task_10.entity.Doctor;
import com.epam.maksym_yena.java.lesson_18.task_10.entity.Specialization;
import com.epam.maksym_yena.java.lesson_18.task_10.entity.Status;
import org.springframework.stereotype.Component;


@Component
public class HospitalDAO
{
    public List<Booking> bookingsList = new ArrayList<>();

    public List<Doctor> doctorStorage = new ArrayList<>();

    private int currentId;
    {
        Doctor doctor = new Doctor();
        doctor.setName("Maxi");
        doctor.setSpecialization(Specialization.Dentist);
        doctorStorage.add(doctor);

        Doctor doctor_2 = new Doctor();
        doctor.setName("Anie");
        doctor.setSpecialization(Specialization.Dentist);
        doctorStorage.add(doctor_2);

        Booking bookingFirst =  new Booking(doctor.getName(),14, Status.Active);
        Booking bookingSecond =  new Booking(doctor_2.getName(),20, Status.Closed);
    }

    public Doctor checkCountOfDoctor(Doctor doctor)
    {
        while (get(currentId) != null){
            currentId++;
        }
        doctor.setId(currentId++);
        doctorStorage.add(doctor);
        return doctor;
    }

    public boolean isFree(Integer time, Booking booking) {
        if(booking.getTimeSlot() == time) {
            booking.setBookingStatus(Status.Active);
            return true;
        }
        else {
            booking.setBookingStatus(Status.Closed);
            return false;
        }
    }

    public Booking add(String name, Integer time) {
        Booking booking = new Booking(name,time,Status.Unknown);
        if(isFree(time,booking)) {
            booking.setBookingStatus(Status.Active);
            bookingsList.add(booking);
        }
        else {
            booking.setBookingStatus(Status.Closed);
        }
        return booking;
    }

    public Booking findDoctor(Integer time, String doctorName, List<Booking> bookingsList) {
        String result = "";
        Booking booking = null;
        for(int i = 0; i < bookingsList.size(); i++) {
            if ((bookingsList.get(i).getTimeSlot() == time) && (bookingsList.get(i).getDoctorName().equals(doctorName))) {
                result = bookingsList.get(i).getDoctorName();
            } else {
                System.out.println("Doctor is`t free");
            }
        }
            for(int i = 0; i < bookingsList.size(); i++) {
                if(bookingsList.get(i).getDoctorName().equals(result)) {
                    booking = bookingsList.get(i);
                }
            }
        return booking;
    }

    public List<Booking> get()
    {
        return bookingsList;
    }

    public Doctor get(long id)
    {
        Optional<Doctor> tvShowOptional = doctorStorage.stream().filter(doctor -> id == doctor.getId()).findAny();
        if (tvShowOptional.isPresent()) {
            return tvShowOptional.get();
        }
        else {
            return null;
        }
    }

    public boolean delete(long id)
    {
        return bookingsList.remove(get(id));
    }

}
