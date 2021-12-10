package com.BookingAndPayment.BookingAndPayment.repository;

import com.BookingAndPayment.BookingAndPayment.models.BookingAndPayment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingAndPaymentRepository extends MongoRepository<BookingAndPayment, String> {

    @Query("{'price':?1,'flightName':?1")
    List<BookingAndPayment> findBookingAndPaymentByBookingPrice(String price, String flightName);

//    List<BookingAndPayment> findBookingAndPayment(String flightName, String price);
}
