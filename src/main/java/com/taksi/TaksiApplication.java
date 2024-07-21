package com.taksi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.taksi")
public class TaksiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaksiApplication.class, args);
	}

}
