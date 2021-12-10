package com.SearchandBooking.searchandbooking.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AirportModel {
        @Id
        @GeneratedValue
        private String airportCode;
        private String airportLocation;
        private String airportName;
        private String flightName;
        private String flightPrice;


    @Override
    public String toString() {
        return "AirportModel{" +
                "airportCode='" + airportCode + '\'' +
                ", airportLocation='" + airportLocation + '\'' +
                ", airportName='" + airportName + '\'' +
                ", flightName='" + flightName + '\'' +
                ", flightPrice='" + flightPrice + '\'' +
                '}';
    }

    public AirportModel() {
    }

    public AirportModel(String airportCode, String airportLocation, String airportName, String flightName, String flightPrice) {
        this.airportCode = airportCode;
        this.airportLocation = airportLocation;
        this.airportName = airportName;
        this.flightName = flightName;
        this.flightPrice = flightPrice;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getAirportLocation() {
        return airportLocation;
    }

    public void setAirportLocation(String airportLocation) {
        this.airportLocation = airportLocation;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getFlightPrice() {
        return flightPrice;
    }

    public void setFlightPrice(String flightPrice) {
        this.flightPrice = flightPrice;
    }
}
