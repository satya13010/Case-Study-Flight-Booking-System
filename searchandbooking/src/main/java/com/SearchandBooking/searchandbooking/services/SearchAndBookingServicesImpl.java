package com.SearchandBooking.searchandbooking.services;

import com.SearchandBooking.searchandbooking.models.AirportModel;
import com.SearchandBooking.searchandbooking.models.SearchAndBooking;
import com.SearchandBooking.searchandbooking.respository.SearchAndBookingRepository;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Service
public class SearchAndBookingServicesImpl implements SearchAndBookingServices{

    @Autowired
    SearchAndBookingRepository searchAndBookingRepository;



    @Override
    public List<SearchAndBooking> getAll() {
        return searchAndBookingRepository.findAll();
    }





    @Override
    public ResponseEntity<?> createBooking(SearchAndBooking searchAndBooking) {
        searchAndBookingRepository.save(searchAndBooking);
        return new ResponseEntity<>(searchAndBooking, HttpStatus.OK);
    }

    @Override
    public List<SearchAndBooking> getAllFlights() {
        return searchAndBookingRepository.findAll();

    }

    @Override
    public void addFlights(@RequestBody SearchAndBooking searchAndBooking) {
        searchAndBookingRepository.save(searchAndBooking);
    }



//    @Override
//    public AirportModel retreiveflights(String airportName, String airportLocation) {
//        AirportModel airportModel= retreiveflights(airportName);
//        if(airportModel==null) {
//            return null;
//        }
//        }
//    }

//    private AirportModel retreiveflights(String airportName) {
//        for (AirportModel  airportModel1: airportName) {
//            if (airportModel1.getAirportName().equals(airportName)) {
//                return airportModel1;
//            }
//            return null;
//    }

//    public Course retrieveCourse(String studentId, String courseId) {
//        Student student = retrieveStudent(studentId);
//
//        if (student == null) {
//            return null;
//        }
//        for (Course course : student.getCourses()) {
//            if (course.getId().equals(courseId)) {
//                return course;
//            }
//        }
//        return null;
//    }


//    @Override
//    public SearchAndBooking save(SearchAndBooking searchAndBooking1) {
//        return searchAndBookingRepository.save(searchAndBooking1);
//    }


    //2nd method to create flight





}
