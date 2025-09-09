package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@SpringBootApplication
public class DemoCallMeApplication {

	private Logger LOGGER = LoggerFactory.getLogger(DemoCallMeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoCallMeApplication.class, args);
	}
	@Autowired
	Optional<BuildProperties> buildProperties;

	@GetMapping("/callme")
	public String getCallMe(){
		LOGGER.info("Ping: name={}", buildProperties.or(Optional::empty));
		return "call me on ping pong";
	}

}
