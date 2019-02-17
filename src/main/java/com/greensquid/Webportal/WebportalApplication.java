package com.greensquid.Webportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={"com.greensquid.DevServers"})
@EntityScan(basePackages = {"com.greensquid.DevServers.model"})
@EnableJpaRepositories(basePackages = {"com.greensquid.DevServers.repository"})
public class WebportalApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebportalApplication.class, args);
	}
}

