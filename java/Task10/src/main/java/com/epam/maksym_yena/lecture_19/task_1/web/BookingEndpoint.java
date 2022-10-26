package com.epam.maksym_yena.lecture_19.task_1.web;

import com.epam.maksym_yena.lecture_19.task_1.hospital.AddBookingRequest;
import com.epam.maksym_yena.lecture_19.task_1.hospital.AddBookingResponse;
import com.epam.maksym_yena.lecture_19.task_1.services.BookingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class BookingEndpoint {
    private static final String NAMESPACE_URI = "http://preprod/qa/soap";

    private BookingServices bookingServices;

    @Autowired
    public BookingEndpoint(BookingServices bookingServices) {
        this.bookingServices = bookingServices;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addBookingRequest")
    @ResponsePayload
    public AddBookingResponse addBooking (@RequestPayload AddBookingRequest request) {
        AddBookingResponse response = new AddBookingResponse();
        response.setBooking(bookingServices.getBooking(request.getDoctorName(),request.getTimeSlot()));
        return response;
    }
}
