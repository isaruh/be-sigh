package com.isaruh.sigh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // use auditing from jpa
public class SighApplication {

	public static void main(String[] args) {
		SpringApplication.run(SighApplication.class, args);
	}

    // TODO
    // 1. create entity
    // 2. create model
    // 3. create repository
    // 4. create service
    // 5. create controller
}
