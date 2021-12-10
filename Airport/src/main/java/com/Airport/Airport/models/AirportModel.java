package com.Airport.Airport.models;


import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AirportModel {


        @Id
        private String airportName;
        @Field
        private String airportCode;
        @Field
        private String airportLocation;
        @Field
        private String flightName;
        @Field
        private String flightPrice;


    public AirportModel() {
    }

    public AirportModel(String airportCode, String airportLocation, String airportName, String flightName, String flightPrice) {
        this.airportCode = airportCode;
        this.airportLocation = airportLocation;
        this.airportName = airportName;
        this.flightName = flightName;
        this.flightPrice = flightPrice;
    }

    public AirportModel(String airportLocation, String airportName) {
        this.airportLocation = airportLocation;
        this.airportName = airportName;
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
}
