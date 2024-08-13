package com.dimSearch.nDimSearch;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NDimSearchApplication {
	private static final Logger log = LogManager.getLogger(NDimSearchApplication.class.getName());
	public static void main(String[] args) {

		SpringApplication.run(NDimSearchApplication.class, args);
		log.info("PROGRAM START - VERIFIED");
	}

}
