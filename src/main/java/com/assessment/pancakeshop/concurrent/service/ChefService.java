package com.assessment.pancakeshop.concurrent.service;

import com.assessment.pancakeshop.concurrent.model.Pancake;
import com.assessment.pancakeshop.concurrent.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class ChefService {

    private Flux<Pancake> pancakes = Flux.empty();
    public void bakePancake(User user) {
        if (Objects.equals(user.getRole(), "Chef")) {
            List<Pancake> list = new ArrayList<>();
            log.info("Pancake Baking has Started");
            for (int i = 1; i <= 12; i++) {
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

    public void servePancake(Flux<User> customers){
        customers.subscribe((user)->{
             user.eat(pancakes);
        });
    }

}
