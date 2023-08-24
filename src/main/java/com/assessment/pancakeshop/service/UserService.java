package com.assessment.pancakeshop.service;

import com.assessment.pancakeshop.model.Pancake;
import com.assessment.pancakeshop.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class UserService {

    private Flux<Pancake> pancakes = Flux.empty();
    public void bakePancake(User user) {
        if (Objects.equals(user.getRole(), "Chef")) {
            List<Pancake> list = new ArrayList<>();
            log.info("Pancake Baking has Started");
            for (int i = 1; i <= 3; i++) {
                Pancake pancake = Pancake.builder()
                        .name("Pancake " + i)
                        .price(500.00)
                        .quantity(1)
                        .build();
                list.add(pancake);
            }
            pancakes = Flux.fromIterable(list);
            log.info("Pancake Baking has Ended");
        }
    }

    public void eat(User user1, User user2, User user3) {
        if (Objects.equals(user1.getRole(), "Customer")) {
            pancakes.delayElements(Duration.ofSeconds(30))
                    .subscribe((pancake)->{
                        log.info(user1.getName() + " has started eating");
                        log.info(pancake.getName() + " has been eaten");
                    });

            log.info(user1.getName() + " has finished eating");
        }
    }
}
