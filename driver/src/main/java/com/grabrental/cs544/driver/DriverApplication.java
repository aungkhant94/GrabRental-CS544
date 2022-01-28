package com.grabrental.cs544.driver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan("com.grabRental.cs544.*")
@ComponentScan("com.grabrental.cs544.*")
//@EnableDiscoveryClient
public class DriverApplication {

	public static void main(String[] args) {
		SpringApplication.run(DriverApplication.class, args);
	}

}
