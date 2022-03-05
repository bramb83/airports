package it.airports;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MyAirportsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyAirportsApplication.class, args);
	}

}
