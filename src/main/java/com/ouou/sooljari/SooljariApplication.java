package com.ouou.sooljari;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SooljariApplication {

	public static void main(String[] args) {
		SpringApplication.run(SooljariApplication.class, args);
	}

}
