package com.grabrental.cs544.vehicle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.grabRental.cs544.*")
public class VehicleApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicleApplication.class, args);
	}

}
