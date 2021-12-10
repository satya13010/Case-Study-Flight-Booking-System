package com.SearchandBooking.searchandbooking.models;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import java.io.Serializable;

@Table
@Getter
@Setter
@ToString
@Entity
@ApiModel(description = "Details about the Booking")
public class SearchAndBooking implements Serializable {
//    @javax.persistence.Id
//    @Column(name = "Id", nullable = false)
//    private String Id;

    @javax.persistence.Id
    private String Id;
    @Field
    private String name;
    @Field
    private String StartPoint;
    @Field
    private String EndPoint;

    @Override
    public String toString() {
        return "SearchAndBooking{" +
                "Id='" + Id + '\'' +
                ", name='" + name + '\'' +
                ", StartPoint='" + StartPoint + '\'' +
                ", EndPoint='" + EndPoint + '\'' +
                '}';
    }



    public SearchAndBooking() {
    }

    public SearchAndBooking(String name, String startPoint, String endPoint) {
        this.name = name;
        StartPoint = startPoint;
        EndPoint = endPoint;
    }

    public SearchAndBooking(String name) {
        this.name = name;
    }

    public SearchAndBooking(String id, String name, String startPoint, String endPoint) {
        Id = id;
        this.name = name;
        StartPoint = startPoint;
        EndPoint = endPoint;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartPoint() {
        return StartPoint;
    }

    public void setStartPoint(String startPoint) {
        StartPoint = startPoint;
    }

    public String getEndPoint() {
        return EndPoint;
    }

    public void setEndPoint(String endPoint) {
        EndPoint = endPoint;
    }
}
