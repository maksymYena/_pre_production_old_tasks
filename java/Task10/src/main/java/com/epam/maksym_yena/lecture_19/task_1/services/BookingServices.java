package com.epam.maksym_yena.lecture_19.task_1.services;

import com.epam.maksym_yena.lecture_19.task_1.dao.BookingDAO;
import com.epam.maksym_yena.lecture_19.task_1.hospital.Booking;
import com.epam.maksym_yena.lecture_19.task_1.hospital.Status;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.Set;


@Component
public class BookingServices {

    private Set<Booking> bookingsActive;
    private Set<Booking> bookingsClosed ;


    public BookingServices() {
        bookingsActive = BookingDAO.getBookingsActive();
        bookingsClosed = BookingDAO.getBookingsClosed();
    }

    public Booking getBooking (String doctorName, BigInteger timeSlot ) {
        for(Booking b: bookingsActive){
            if (b.getDoctorName().equals(doctorName) &&
            b.getTimeSlot().intValue() == timeSlot.intValue()){
                return b;
            }
        }
        return null;
    }

    public String setBookingActiveClosedStatus (Booking choosenBooking) {
        if (choosenBooking.getBookingStatus() == Status.ACTIVE){
            if (isContain(bookingsActive,choosenBooking)){
                removeBooking(bookingsActive,choosenBooking);
                choosenBooking.setBookingStatus(Status.CLOSED );
                bookingsClosed.add(choosenBooking);
                return "Success booking";
            }
            else {
                return "This item does not found in Active Shedule";
            }
        }
        else {
            if (isContain(bookingsClosed,choosenBooking)) {
                removeBooking(bookingsClosed, choosenBooking);
                choosenBooking.setBookingStatus(Status.ACTIVE);
                bookingsActive.add(choosenBooking);
                return "Success unbooking";
            }
            else {
                return "This item does not found in Closed Shedule";
            }
        }
    }

    private void removeBooking (Set<Booking> setBooking, Booking booking){
        Booking remBooking = new Booking();
        for (Booking b : setBooking){
            if (b.getDoctorName().equals(booking.getDoctorName()) &&
                    b.getTimeSlot().intValue() == booking.getTimeSlot().intValue()){
                remBooking = b;
                break;
            }
        }
        setBooking.remove(remBooking);
    }

    private boolean isContain (Set<Booking> setBooking, Booking booking){
        for (Booking b : setBooking){
            if (b.getDoctorName().equals(booking.getDoctorName()) &&
                    b.getTimeSlot().intValue() == booking.getTimeSlot().intValue()) {
                return true;
            }
        }
        return false;
    }


}
