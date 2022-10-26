package com.epam.maksym_yena.lecture_19.task_1.web;

import com.epam.maksym_yena.lecture_19.task_1.dao.BookingDAO;
import com.epam.maksym_yena.lecture_19.task_1.hospital.Booking;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(value = "/bookingList")
public class BookingRest {

    @RequestMapping(value = "/active", method = RequestMethod.GET)
    @ResponseBody
    public Set<Booking> getActive()    {
        return BookingDAO.getBookingsActive();
    }

    @RequestMapping(value = "/closed", method = RequestMethod.GET)
    @ResponseBody
    public Set<Booking> getClosed()    {
        return BookingDAO.getBookingsClosed();
    }
}
