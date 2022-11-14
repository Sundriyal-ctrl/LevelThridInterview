package com.LevelThirdInterview;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LevelThirdInterviewApplication {
   @Bean
	public ModelMapper getModel()
   {
	   return new ModelMapper();
   }
	public static void main(String[] args) {
		SpringApplication.run(LevelThirdInterviewApplication.class, args);
	}

}
