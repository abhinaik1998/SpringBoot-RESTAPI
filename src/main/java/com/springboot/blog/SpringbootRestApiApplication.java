package com.springboot.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springboot.blog.Entity.Post;

@SpringBootApplication
public class SpringbootRestApiApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext ctx = SpringApplication.run(SpringbootRestApiApplication.class, args);
		
		
		
	}

}
