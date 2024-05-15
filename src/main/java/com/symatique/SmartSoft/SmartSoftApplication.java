package com.symatique.SmartSoft;

import java.util.Base64;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.symatique.SmartSoft")
public class SmartSoftApplication {


	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SmartSoftApplication.class, args);
	}
	
	
	

}
