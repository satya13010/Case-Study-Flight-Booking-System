package com.Airport.Airport.repository;

import com.Airport.Airport.models.AirportModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Repository
public interface AirportRepository extends MongoRepository<AirportModel, String> {



//    List<AirportModel> findByNameAndLocation(String airportName, String airportLocation);

    List<AirportModel> findByAirportNameAndAirportLocation(String airportName, String airportLocation);
}
