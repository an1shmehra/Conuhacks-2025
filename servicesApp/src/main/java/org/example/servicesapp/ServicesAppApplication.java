package org.example.servicesapp;

import org.example.servicesapp.util.MongoDB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ServicesAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicesAppApplication.class, args);
		MongoDB.Connect();
	}

	@GetMapping("/")
	public String root(){
		return "Hello!";
	}

}
