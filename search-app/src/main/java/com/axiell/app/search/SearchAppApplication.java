package com.axiell.app.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

@EnableAutoConfiguration
@EnableEurekaClient
@SpringBootApplication
@Import(RestConfig.class)
public class SearchAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchAppApplication.class, args);
	}
}
