package com.SearchandBooking.searchandbooking.respository;

import com.SearchandBooking.searchandbooking.models.AirportModel;
import com.SearchandBooking.searchandbooking.models.SearchAndBooking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SearchAndBookingRepository extends MongoRepository<SearchAndBooking, String> {


}
