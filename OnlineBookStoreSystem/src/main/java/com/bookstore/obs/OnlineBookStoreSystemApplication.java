package com.bookstore.obs;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OnlineBookStoreSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineBookStoreSystemApplication.class, args);
	}
	
	@Bean
	public  ModelMapper modelmapper()
{
	return new ModelMapper();
}

}
