package com.epam.maksym_yena.java.lesson_18.task_10.entity;

public class Booking {
    String doctorName;
    Integer timeSlot;
    Status bookingStatus;

    public Booking(String doctorName, Integer timeSlot, Status bookingStatus) {
        this.doctorName = doctorName;
        this.timeSlot = timeSlot;
        this.bookingStatus = bookingStatus;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Integer getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(Integer timeSlot) {
        this.timeSlot = timeSlot;
    }

    public Status getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(Status bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
