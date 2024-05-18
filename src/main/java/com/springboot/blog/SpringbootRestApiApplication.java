package com.springboot.blog;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.springboot.blog.Entity.Post;

@SpringBootApplication
public class SpringbootRestApiApplication {


	
	public static void main(String[] args) {
	ConfigurableApplicationContext ctx1 = SpringApplication.run(SpringbootRestApiApplication.class, args);
		
	
		
	}
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	 @Bean
	    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
	        return args -> {
	            if (ctx.containsBean("modelMapper")) {
	                System.out.println("ModelMapper bean is present in the ApplicationContext.");
	            } else {
	                System.out.println("ModelMapper bean is not present in the ApplicationContext.");
	            }
	        };
	    }
} 
