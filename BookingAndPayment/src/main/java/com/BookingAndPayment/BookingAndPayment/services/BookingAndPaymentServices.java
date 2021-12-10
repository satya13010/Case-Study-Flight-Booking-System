package com.BookingAndPayment.BookingAndPayment.services;

import com.BookingAndPayment.BookingAndPayment.exceptions.RecordNotFoundException;
import com.BookingAndPayment.BookingAndPayment.models.BookingAndPayment;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Stream;

public interface BookingAndPaymentServices {


    Iterable<BookingAndPayment> getAllBooking();

    ResponseEntity<?> getBookingByID(String bookingId);

    ResponseEntity<?> createNewBooking(BookingAndPayment bookingAndPayment);

    BookingAndPayment updateBooking(BookingAndPayment updateBooking) throws RecordNotFoundException;

    String deleteBooking(String bookingId) throws RecordNotFoundException;

    List<BookingAndPayment> getAllFlights();

}
