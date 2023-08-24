package com.assessment.pancakeshop;

import com.assessment.pancakeshop.model.User;
import com.assessment.pancakeshop.service.ChefService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class PancakeShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(PancakeShopApplication.class, args);
	}

	@Component
	public class ApplicationRunner implements CommandLineRunner{
		@Override
		public void run(String... args){
			ChefService chefService = new ChefService();
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

			chefService.bakePancake(chef);
			Flux<User> users = Flux.just(user1,user2,user3);
			chefService.servePancake(users);

		}
	}

}
