package com.axiell.service.audit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

@EnableAutoConfiguration
@EnableEurekaClient
@SpringBootApplication
@Import(SolrConfig.class)
public class AuditServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuditServiceApplication.class, args);
	}
}
