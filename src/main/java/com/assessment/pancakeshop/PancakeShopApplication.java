package com.assessment.pancakeshop;

import com.assessment.pancakeshop.concurrent.model.Pancake;
import com.assessment.pancakeshop.concurrent.model.User;
import com.assessment.pancakeshop.concurrent.service.ChefService;
import com.assessment.pancakeshop.non_concurrent.model.PancakeN;
import com.assessment.pancakeshop.non_concurrent.model.UserN;
import com.assessment.pancakeshop.non_concurrent.service.ChefServiceN;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PancakeShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(PancakeShopApplication.class, args);
	}

	@Component
	public class ApplicationRunner implements CommandLineRunner{
		@Override
		public void run(String... args) {
			//runConcurrent();
			runNonConcurrent();
		}
	}

	public static void runConcurrent(){
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

	public static void runNonConcurrent(){
		ChefServiceN chefServiceN = new ChefServiceN();
		UserN userN1 = UserN.builder()
				.name("userN1")
				.role("Customer")
				.build();

		UserN userN2 = UserN.builder()
				.name("userN2")
				.role("Customer")
				.build();

		UserN userN3 = UserN.builder()
				.name("userN3")
				.role("Customer")
				.build();

		UserN chefN = UserN.builder()
				.name("ChefN")
				.role("ChefN")
				.build();

		chefServiceN.bakePancake(chefN);
		List<PancakeN> pancakes = chefServiceN.getPancakesN();
		userN1.eat(pancakes);
		userN2.eat(pancakes);
		userN3.eat(pancakes);
	}

}
