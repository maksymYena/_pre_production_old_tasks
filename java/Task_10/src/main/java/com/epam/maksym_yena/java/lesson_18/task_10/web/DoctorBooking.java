package com.epam.maksym_yena.java.lesson_18.task_10.web;


import com.epam.maksym_yena.java.lesson_18.task_10.entity.addBooking.addBookingRequest;
import com.epam.maksym_yena.java.lesson_18.task_10.entity.addBooking.addBookingResponse;
import com.epam.maksym_yena.java.lesson_18.task_10.service.BookingDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class DoctorBooking
{
    private static final String NAMESPACE_URI = "http://preprod/qa/soap";

    private BookingDoctorService bookingDoctorService;

    @Autowired
    public DoctorBooking(BookingDoctorService bookingServices)
    {
        this.bookingDoctorService = bookingDoctorService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addBookingRequest")
    @ResponsePayload
    public addBookingResponse addBookingDoctor(@RequestPayload addBookingRequest request)
    {
        addBookingResponse response = new addBookingResponse();
        response.setBooking(bookingDoctorService.create(request.getDoctorName(),request.getTimeSlot()));
        return response;
    }

}
