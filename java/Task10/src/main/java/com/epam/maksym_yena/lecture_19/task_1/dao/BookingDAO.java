package com.epam.maksym_yena.lecture_19.task_1.dao;

import com.epam.maksym_yena.lecture_19.task_1.hospital.Booking;
import com.epam.maksym_yena.lecture_19.task_1.hospital.Doctor;
import com.epam.maksym_yena.lecture_19.task_1.hospital.Specialization;
import com.epam.maksym_yena.lecture_19.task_1.hospital.Status;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;


@Component
public class BookingDAO {
    private static final Set<Booking> bookingsActive = new HashSet<Booking>();
    private static final Set<Booking> bookingsClosed = new HashSet<Booking>();

    @PostConstruct
    public void initData ()
    {
        Doctor doctorOne = new Doctor();
        doctorOne.setName("Ivan");
        doctorOne.setSpecialization(Specialization.DENTIST);

        Doctor doctorTwo = new Doctor();
        doctorTwo.setName("Semen");
        doctorTwo.setSpecialization(Specialization.NEUROSURGEONS);

        Booking booking1 = new Booking();
        booking1.setDoctorName(doctorOne.getName());
        booking1.setTimeSlot(BigInteger.valueOf(1));
        booking1.setBookingStatus(Status.ACTIVE);

        Booking booking2 = new Booking();
        booking2.setDoctorName(doctorOne.getName());
        booking2.setTimeSlot(BigInteger.valueOf(3));
        booking2.setBookingStatus(Status.ACTIVE);

        Booking booking3 = new Booking();
        booking3.setDoctorName(doctorTwo.getName());
        booking3.setTimeSlot(BigInteger.valueOf(1));
        booking3.setBookingStatus(Status.ACTIVE);

        Booking booking4 = new Booking();
        booking4.setDoctorName(doctorTwo.getName());
        booking4.setTimeSlot(BigInteger.valueOf(4));
        booking4.setBookingStatus(Status.ACTIVE);

        bookingsActive.add(booking1);
        bookingsActive.add(booking2);
        bookingsActive.add(booking3);
        bookingsActive.add(booking4);
    }

    public static Set<Booking> getBookingsActive() {
        return bookingsActive;
    }

    public static Set<Booking> getBookingsClosed() {
        return bookingsClosed;
    }

}
