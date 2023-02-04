package com.personPractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;

@SpringBootApplication
public class PersonPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonPracticeApplication.class, args);
	}

}
