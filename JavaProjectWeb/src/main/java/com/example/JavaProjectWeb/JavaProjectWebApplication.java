package com.example.JavaProjectWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={"com.example.JavaProjectWeb","repositoryservicesfacades","webservices"})
@EnableJpaRepositories ("databaserepository")
@EntityScan("javabeansentity")
public class JavaProjectWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaProjectWebApplication.class, args);
		
	}
}
