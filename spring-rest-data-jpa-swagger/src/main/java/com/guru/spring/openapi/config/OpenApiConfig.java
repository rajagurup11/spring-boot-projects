/**
 * @author Rajaguru Paramasivam
 * 26-Nov-2021 2:33:59 pm
 * rajagurup11@gmail.com
 */
package com.guru.spring.openapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().components(new Components()).info(new Info().title("Employee Application API")
				.description("This is a sample Spring Boot RESTful service using springdoc-openapi and OpenAPI 3."));
	}
}
