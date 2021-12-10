package com.BookingAndPayment.BookingAndPayment.controller;

import com.BookingAndPayment.BookingAndPayment.exceptions.RecordNotFoundException;
import com.BookingAndPayment.BookingAndPayment.models.AirportModel;
import com.BookingAndPayment.BookingAndPayment.models.BookingAndPayment;
import com.BookingAndPayment.BookingAndPayment.repository.BookingAndPaymentRepository;
import com.BookingAndPayment.BookingAndPayment.services.BookingAndPaymentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;


@RestController
@CrossOrigin(origins="http://localhost:4200/")
@RequestMapping("/BookingAndPayment")
public class BookingAndPaymentController {

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @Autowired
    BookingAndPaymentRepository bookingAndPaymentRepository;

    @Autowired
    BookingAndPaymentServices bookingAndPaymentServices;



    //posting products doesnt return anything
    @PostMapping("/CreateBooking")
    public void createBooking(@RequestBody BookingAndPayment bookingAndPayment)
    {
        bookingAndPaymentServices.createNewBooking(bookingAndPayment);
        System.out.println("created");

    }


    //get all products
    @GetMapping("/getAllBooking")
    public Iterable<BookingAndPayment> getAllBooking(){
        return bookingAndPaymentServices.getAllBooking();
    }



    @GetMapping("/getAllBooking/{bookingId}")
    public ResponseEntity<?> getBookingByID(@PathVariable("bookingId") String bookingId){
        return bookingAndPaymentServices.getBookingByID(bookingId);

    }

    @PutMapping("/UpdateBooking")
    @ExceptionHandler(RecordNotFoundException.class)
    public void UpdateBooking(@RequestBody BookingAndPayment updateBooking) throws RecordNotFoundException {
        bookingAndPaymentServices.updateBooking(updateBooking);
    }

    @DeleteMapping("/DeleteBooking/{bookingId}")
    @ExceptionHandler(RecordNotFoundException.class)
    public void deleteBookingByID(@PathVariable("bookingId") String bookingId) throws RecordNotFoundException {
        bookingAndPaymentServices.deleteBooking(bookingId);
    }


    @GetMapping("/GetList")
    public Iterable<BookingAndPayment> fetchFlight(){
        return bookingAndPaymentServices.getAllBooking();
    }


    @GetMapping("/GetList/{price}/{flightName}")
    public List<BookingAndPayment> fetchFlight(@PathVariable(value="price") String price,
                                               @PathVariable(value="flightName") String flightName) {

        return bookingAndPaymentRepository.findBookingAndPaymentByBookingPrice(price, flightName);
    }

    @PostMapping("/OnBooking")
    @CrossOrigin(origins="http://localhost:4200/")
    public AirportModel getNewlyCreatedBooking(@RequestBody AirportModel airportModel)
    {
        AirportModel airportModel1 = restTemplateBuilder.build().postForObject("http://localhost:9010/Airport/addAirport", airportModel,AirportModel.class);
        System.out.println("createdBooking is:" + airportModel1);
        return airportModel1;
    }


    @PutMapping("/customers/{id}")
    public ResponseEntity<BookingAndPayment> updateCustomer(@RequestBody BookingAndPayment bookingAndPayment) {

        try {
            return new ResponseEntity<BookingAndPayment>(bookingAndPaymentRepository.save(bookingAndPayment), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


//    @GetMapping("/Multiple Values")
//    public ResponseEntity<?> getValue(@RequestParam(required = false) String flightName, @RequestParam(required = false) String price){
//        return new ResponseEntity<>(bookingAndPaymentRepository.findBookingAndPayment(flightName,price),HttpStatus.OK);
//
//    }

}
