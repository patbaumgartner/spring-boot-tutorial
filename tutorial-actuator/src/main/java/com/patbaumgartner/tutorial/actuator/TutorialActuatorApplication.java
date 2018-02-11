package com.patbaumgartner.tutorial.actuator;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TutorialActuatorApplication {

	@Autowired
	private DataSource dataSource;
	
	public static void main(String[] args) {
		SpringApplication.run(TutorialActuatorApplication.class, args);
	}
}
