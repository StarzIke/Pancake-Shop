package com.assessment.pancakeshop.concurrent.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Slf4j
public class User {
    private String name;
    private String role;

    public void eat(Flux<Pancake> pancakes) {
        if (Objects.equals(role, "Customer")) {
            pancakes.delayElements(Duration.ofSeconds(30))
                    .subscribe((pancake)->{
                        log.info(name + " has started eating");
                        log.info(pancake.getName() + " has been eaten");
                    });

            log.info(name + " has finished eating");
        }
    }

}
