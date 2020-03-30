package com.hello.api;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloApiApplication {

	private static final Logger LOG = Logger.getLogger(HelloApiApplication.class);

	public static void main(String[] args) {
		if (LOG.isInfoEnabled()) {
			LOG.info("Starting Hello API ...");
		}
		SpringApplication.run(HelloApiApplication.class, args);
	}

}
