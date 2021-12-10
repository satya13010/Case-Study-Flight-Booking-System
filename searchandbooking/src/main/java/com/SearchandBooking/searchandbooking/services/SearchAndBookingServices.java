package com.SearchandBooking.searchandbooking.services;

import com.SearchandBooking.searchandbooking.models.AirportModel;
import com.SearchandBooking.searchandbooking.models.SearchAndBooking;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;



public interface SearchAndBookingServices {



    List<SearchAndBooking> getAll();



    ResponseEntity<?> createBooking(SearchAndBooking searchAndBooking);

    List<SearchAndBooking> getAllFlights();

    void addFlights(SearchAndBooking searchAndBooking);

//    AirportModel retreiveflights(String airportName, String airportLocation);




//    SearchAndBooking save(SearchAndBooking searchAndBooking1);


}
