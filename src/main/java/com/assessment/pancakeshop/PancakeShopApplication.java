package com.assessment.pancakeshop;

import com.assessment.pancakeshop.model.User;
import com.assessment.pancakeshop.service.UserService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class PancakeShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(PancakeShopApplication.class, args);
	}

	@Component
	public class ApplicationRunner implements CommandLineRunner{
		@Override
		public void run(String... args){
			UserService userService = new UserService();
			User user1 = User.builder()
					.name("user1")
					.role("Customer")
					.build();

			User user2 = User.builder()
					.name("user2")
					.role("Customer")
					.build();

			User user3 = User.builder()
					.name("user3")
					.role("Customer")
					.build();

			User chef = User.builder()
					.name("Chef")
					.role("Chef")
					.build();

			userService.bakePancake(chef);
			userService.eat(user1, user2, user3);
		}
	}

}
