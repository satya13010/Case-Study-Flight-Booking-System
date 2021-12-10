package com.BookingAndPayment.BookingAndPayment.exceptions;

public class RecordNotFoundException extends Throwable {
    public RecordNotFoundException(String s){
        super(s);
        System.out.println("not found");
    }
}
