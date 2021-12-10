package com.BookingAndPayment.BookingAndPayment.services;


import com.BookingAndPayment.BookingAndPayment.exceptions.RecordNotFoundException;
import com.BookingAndPayment.BookingAndPayment.models.BookingAndPayment;
import com.BookingAndPayment.BookingAndPayment.repository.BookingAndPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class BookingAndPaymentServicesImpl implements BookingAndPaymentServices {


    @Autowired
    BookingAndPaymentRepository bookingAndPaymentRepository;

    @Override
    public Iterable<BookingAndPayment> getAllBooking() {
        return bookingAndPaymentRepository.findAll();
    }

    @Override
    public ResponseEntity<?> getBookingByID(String bookingId) {
        Optional<BookingAndPayment> findById = bookingAndPaymentRepository.findById(bookingId);
        BookingAndPayment findBookingAndPayment = findById.get();
        return new ResponseEntity<BookingAndPayment>(findBookingAndPayment, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> createNewBooking(BookingAndPayment bookingAndPayment) {
        bookingAndPaymentRepository.save(bookingAndPayment);
        return new ResponseEntity<BookingAndPayment>(bookingAndPayment, HttpStatus.OK);
    }

    @Override
    public BookingAndPayment updateBooking(BookingAndPayment updateBooking) throws RecordNotFoundException {
        Optional<BookingAndPayment> findBookingById = bookingAndPaymentRepository.findById((updateBooking.getBookingId()));
        if (findBookingById.isPresent()) {
            bookingAndPaymentRepository.save(updateBooking);

        } else {
            throw new RecordNotFoundException(updateBooking.getBookingId() + "doesnt exist");
        }
        return updateBooking;
    }

    @Override
    public String deleteBooking(String bookingId) throws RecordNotFoundException {
        bookingAndPaymentRepository.deleteById(bookingId);
        return "Booking Deleted";
    }

    @Override
    public List<BookingAndPayment> getAllFlights() {
        return bookingAndPaymentRepository.findAll();
    }




}


