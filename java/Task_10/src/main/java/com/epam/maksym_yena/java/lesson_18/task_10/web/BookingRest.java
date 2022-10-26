package com.epam.maksym_yena.java.lesson_18.task_10.web;

import java.util.List;

import com.epam.maksym_yena.java.lesson_18.task_10.entity.Booking;
import com.epam.maksym_yena.java.lesson_18.task_10.entity.Doctor;
import com.epam.maksym_yena.java.lesson_18.task_10.entity.Specialization;
import com.epam.maksym_yena.java.lesson_18.task_10.service.BookingDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/bookingDoctors")
public class BookingRest
{
    @Autowired
    private BookingDoctorService bookingService;

    public BookingRest(BookingDoctorService bookingService)
    {
        this.bookingService = bookingService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public List<Booking> get()
    {
        return bookingService.get();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Doctor get(@PathVariable long id)
    {
        return bookingService.get(id);
    }


    @RequestMapping(value = "/", method = RequestMethod.PUT)
    @ResponseBody
    public Booking create(@RequestBody String doctor)
    {
        return bookingService.create(doctor,14);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean delete(@PathVariable long id)
    {
        return bookingService.delete(id);
    }

}
