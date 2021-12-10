package com.Airport.Airport.services;


import com.Airport.Airport.models.AirportModel;
import com.Airport.Airport.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirportService implements IAirportService {

    @Autowired
    AirportRepository airportRepository;

    AirportModel airportModel;

    @Override
    public Iterable<AirportModel> viewAllAirport() {
        return airportRepository.findAll();
    }

    @Override
    public ResponseEntity<?> addAirport(AirportModel airport) {
        airportRepository.save(airport);
        return new ResponseEntity<>(airport, HttpStatus.OK);
    }

    @Override
    public AirportModel modifyAirport(AirportModel airport) {
        Optional<AirportModel> findById = airportRepository.findById(airport.getAirportCode());
        airportRepository.save(airport);
        return airport;
    }



    @Override
    public void deleteAirportByName(String airportName) {
        airportRepository.deleteById(airportName);
    }

//    @Override
//    public List<AirportModel> findByIdAndName(String airportName, String airportLocation) {
//        try {
//            if (airportModel.getAirportName() == airportName && airportModel.getAirportLocation() == airportLocation) {
//                return airportRepository.findByNameAndLocation(airportName, airportLocation);
//            }
//
//        } catch (Exception e) {
//            System.out.println(e.getStackTrace());
//            //        return  new List<AirportModel>();
//        }
//        List<AirportModel> emptylist = Collections.emptyList();
//        return emptylist;
//    }

}
