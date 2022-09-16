package com.ouou.sooljari;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication(exclude = SecurityAutoConfiguration.class) // security 기능 해제
public class SooljariApplication {

	public static void main(String[] args) {
		SpringApplication.run(SooljariApplication.class, args);
	}

}
