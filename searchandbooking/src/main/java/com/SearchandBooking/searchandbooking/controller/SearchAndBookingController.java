package com.SearchandBooking.searchandbooking.controller;


import com.SearchandBooking.searchandbooking.models.AirportModel;
import com.SearchandBooking.searchandbooking.models.BookingAndPayment;
import com.SearchandBooking.searchandbooking.models.SearchAndBooking;
import com.SearchandBooking.searchandbooking.respository.SearchAndBookingRepository;
import com.SearchandBooking.searchandbooking.services.SearchAndBookingServices;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api")
public class SearchAndBookingController {


    @Autowired
    SearchAndBookingServices searchAndBookingServices;


    private static Logger LOGGER = LoggerFactory.getLogger(SearchAndBookingController.class);
    //
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Autowired
    SearchAndBookingRepository searchAndBookingRepository;


    //swagger
    @RequestMapping(method = RequestMethod.GET, value = "/api/javainuse")
    public String sayHello() {
        return "Swagger Hello World";
    }


    //swagger


    @GetMapping("/GetAllFlightDetails")
    @CrossOrigin(origins = "http://localhost:4200/")
    public ResponseEntity<List<SearchAndBooking>> getAllFlightDetails() {
        return new ResponseEntity(searchAndBookingServices.getAll(), HttpStatus.OK);
    }

    @PostMapping("/onlineTutorial")
    public void createBooking(@RequestBody SearchAndBooking searchAndBooking) {
        searchAndBookingServices.createBooking(searchAndBooking);
    }

    //most important methods ****Do not delete
    //most important methods
    @GetMapping("/fetchFlights")
    @CrossOrigin(origins = "http://localhost:4200/")
    public List<SearchAndBooking> fetchFlight() {
        List<SearchAndBooking> searchAndBookings = restTemplateBuilder.build().getForObject("http://localhost:9005/BookingAndPayment/GetList",
                List.class);
        return searchAndBookings;
    }
//most important methods

    //most important methods
    @ApiOperation(value = "Create Bookings",
            response = SearchAndBooking.class)
    @PostMapping("/postDataOnBooking")
    @CrossOrigin(origins = "http://localhost:4200/")
    public BookingAndPayment getNewlyCreatedBooking(@RequestBody BookingAndPayment bookingAndPayment) {
        BookingAndPayment bookingAndPayment1 = restTemplateBuilder.build().postForObject("http://localhost:9005/BookingAndPayment/CreateBooking", bookingAndPayment, BookingAndPayment.class);
        System.out.println("createdBooking is:" + bookingAndPayment1);
        return bookingAndPayment;
    }

    //most important methods ****Do not delete
    @CrossOrigin(origins = "http://localhost:4200/")
    @DeleteMapping("/Delete/{Id}")
    public void deletePost(@PathVariable String Id) {
        this.restTemplateBuilder.build().delete("http://localhost:9005/BookingAndPayment/DeleteBooking/{Id}", Id);
    }


    @CrossOrigin(origins = "http://localhost:4200/")
    @PutMapping("/Update/")
    public void UpdateBooking(@RequestBody String bookingId) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(headers);
//        this.restTemplateBuilder.build().put("http://localhost:9005/BookingAndPayment/UpdateBooking/{bookingId}", bookingId);
        ResponseEntity<?> result = restTemplateBuilder.build().exchange("http://localhost:9005/BookingAndPayment/customers/{bookingId}",
                HttpMethod.GET, entity, BookingAndPayment.class, bookingId);
        ResponseEntity<?> response = restTemplateBuilder.build().getForEntity("http://localhost:9005/BookingAndPayment/customers/{bookingId}", BookingAndPayment.class);
    }


//    @GetMapping("/From/{airportName}/To/{airportLocation}")
//    public AirportModel retrieveDetails(@PathVariable String airportName, @PathVariable String airportLocation){
//        return searchAndBookingServices.retreiveflights(airportName,airportName);
//    }

//



//    method hard to do

//    @RequestMapping(value = "findFlights", method = RequestMethod.GET)
//    public SearchAndBooking findFlights(@RequestParam("price") String price, @RequestParam("flightName") String flightName,
//                              ModelMap modelMap) {
//
//        List<SearchAndBooking> flights = searchAndBookingServices.findFlights(price, flightName);
//        modelMap.addAttribute("flights", flights);
//        return
//    }





    @PostMapping("/addFlights")
    public void addFlights(@RequestBody SearchAndBooking searchAndBooking){
        searchAndBookingServices.addFlights(searchAndBooking);
    }




//here starts the website method




 //here ends the website method

//    @PostMapping("/AddFlightDetails")
//    public ResponseEntity<SearchAndBooking> create(@RequestBody SearchAndBooking searchAndBooking1){
//        SearchAndBooking searchAndBooking= searchAndBookingServices.save(searchAndBooking1);
//        return new ResponseEntity<>(searchAndBooking, HttpStatus.CREATED);
//    }
//    @RequestMapping("/Indigo")
//    public List<SearchAndBooking> getFlightDetails(String Id) {
//        return Collections.singletonList(new SearchAndBooking("Indigo"));
//    }
//
//
//    @RequestMapping(value = "/tempfile", method=RequestMethod.POST, consumes = "application/json")
//    public String getData(@RequestBody SearchAndBooking searchAndBooking){
//        return "flight details are "+ searchAndBooking.toString();
//    }
//
//    @RequestMapping("/SpiceJet")
//    public SearchAndBooking getSingleFlightDetails(){
//        return new SearchAndBooking("SpiceJet");
//    }




}
