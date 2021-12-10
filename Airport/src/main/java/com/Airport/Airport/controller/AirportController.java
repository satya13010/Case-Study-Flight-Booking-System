package com.Airport.Airport.controller;


import com.Airport.Airport.models.AirportModel;
import com.Airport.Airport.repository.AirportRepository;
import com.Airport.Airport.services.IAirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/Airport")
public class AirportController {

    @Autowired
    IAirportService airportService;


    @Autowired
    AirportRepository airportRepository;


    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/allAirport")
    public Iterable<AirportModel> viewAllAirport() {
        return airportService.viewAllAirport();
    }

    @PostMapping("/addAirport")
    public void addAirport(@RequestBody AirportModel airport) {
        airportService.addAirport(airport);
    }

    @PutMapping("/updateAirport")
    public void modifyAirport(@RequestBody AirportModel airport) {
        airportService.modifyAirport(airport);
    }

    @DeleteMapping("/deleteAirport/{airportName}")
    public ResponseEntity<?> removeAirport(@PathVariable("airportName") String airportName) {
        airportService.deleteAirportByName(airportName);
        return new ResponseEntity<>(airportName,OK);
    }


//    @GetMapping("/flights")
//    public ResponseEntity<List<AirportModel>> getFlightsBy(@RequestParam String airportName, @RequestParam String airportLocation){
//        return new ResponseEntity<List<AirportModel>>(airportRepository.findByNameAndLocation(airportName,airportLocation), HttpStatus.OK);
//    }


    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/travellingFrom/{airportName}/{airportLocation}")
    public ResponseEntity<List<AirportModel>> getFlights(@PathVariable("airportName") String airportName, @PathVariable("airportLocation") String airportLocation){
        return new ResponseEntity<List<AirportModel>>(airportRepository.findByAirportNameAndAirportLocation(airportName, airportLocation), OK);
    }


// didi waala method

//    @GetMapping("/api/{airportName}/{airportLocation}")
//    @ResponseBody
//    public List<AirportModel> getStudentsByIdClass(@PathVariable Map<String, String> map) {
//        String airportName = map.get("airportName");
//        String airportLocation = map.get("airportLocation");
//        return airportService.findByIdAndName(airportName, airportLocation);
//    }
//
//}
}