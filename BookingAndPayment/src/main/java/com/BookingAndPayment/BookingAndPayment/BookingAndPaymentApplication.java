package com.BookingAndPayment.BookingAndPayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableMongoRepositories
public class BookingAndPaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingAndPaymentApplication.class, args);
	}

}
