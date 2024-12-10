package com.prepquest.prepquest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.prepquest.prepquest.repository")
@EntityScan(basePackages = "com.prepquest.prepquest.model")
public class PrepquestApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrepquestApplication.class, args);
		System.out.println("PrepQuest Backend Is Running");
	}

}
