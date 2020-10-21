package com.packt.cardatabase;
import org.slf4j.Logger; //allows Spring Boot Logger
import org.slf4j.LoggerFactory; //allows Spring Boot Logger
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CardatabaseApplication {
	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);
	public static void main(String[] args) {
		
		SpringApplication.run(CardatabaseApplication.class, args);
			logger.info("Hsello Spring Boot");
	}

}
