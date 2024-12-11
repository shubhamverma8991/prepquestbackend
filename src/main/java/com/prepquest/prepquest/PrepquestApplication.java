package com.prepquest.prepquest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PrepquestApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PrepquestApplication.class, args);
		System.out.println("PrepQuest Backend Is Running");
	}

}
