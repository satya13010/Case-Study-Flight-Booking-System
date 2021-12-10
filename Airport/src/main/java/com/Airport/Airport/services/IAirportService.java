package com.Airport.Airport.services;

import com.Airport.Airport.models.AirportModel;
import org.springframework.http.ResponseEntity;

public interface IAirportService {

    Iterable<AirportModel> viewAllAirport();

    ResponseEntity<?> addAirport(AirportModel airport);

    AirportModel modifyAirport(AirportModel airport);

    void deleteAirportByName(String airportCode);


//    List<AirportModel> findByIdAndName(String airportName, String airportLocation);
}
