package com.pilot.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

<<<<<<< HEAD:src/main/java/com/pilot/main/Application.java
<<<<<<< HEAD:src/main/java/com/pilot/main/PilotMainSpringApp.java
public class PilotMainSpringApp {

	private static final Logger logger = LoggerFactory.getLogger(PilotMainSpringApp.class);
=======
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);
>>>>>>> ssointegration:src/main/java/com/pilot/main/Application.java
=======
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);
>>>>>>> c23f1a2dac02f9465e3f80b3c9688dce9ef023f1:src/main/java/com/pilot/main/Application.java

	public static void main(String[] args) {
		// added new comment
		logger.info("starting spring");
		SpringApplication.run(Application.class, args);
	}
}