package com.SearchandBooking.searchandbooking.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;


public class BookingAndPayment {

    @Id
    private String bookingId;
    @Field
    private String bookingDate;
    @Field
    private String totalPassengers;
    @Field
    private String flightName;
    @Field
    private String price;

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getTotalPassengers() {
        return totalPassengers;
    }

    public void setTotalPassengers(String totalPassengers) {
        this.totalPassengers = totalPassengers;
    }


    public BookingAndPayment() {
    }



    public BookingAndPayment(String flightName, String price, String bookingId, String bookingDate, String totalPassengers) {
        this.bookingId = bookingId;
        this.bookingDate = bookingDate;
        this.totalPassengers = totalPassengers;
        this.flightName= flightName;
        this.price = price;
    }





}
