package com.online.bsms;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OnlineBookStoreManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineBookStoreManagementSystemApplication.class, args);
	}
	@Bean 
	public ModelMapper modelmapper() 
	{
		return new ModelMapper();
	}

}
