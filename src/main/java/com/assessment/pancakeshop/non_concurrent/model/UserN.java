package com.assessment.pancakeshop.non_concurrent.model;

import com.assessment.pancakeshop.concurrent.model.Pancake;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Slf4j
public class UserN {
    private String name;
    private String role;

    public void eat(List<PancakeN> pancakesN) {
        TimerTask timerTask = new TimerTask() {
            public void run() {
                if (Objects.equals(role, "Customer")) {
                    log.info(name + " has started eating");
                    int noOfPancakesEaten = 0;
                    for (int i = 1; i <=5; i++) {
                        if (!pancakesN.isEmpty()) {
                            PancakeN pancakeN = pancakesN.get(i);
                            pancakesN.remove(pancakeN);
                            log.info(pancakeN.getName() + " has been eaten");
                            noOfPancakesEaten++;
                        }else {
                            log.info("No more pancake");
                            break;
                        }
                    }
                    if (noOfPancakesEaten == 5){
                        log.info(name + " has finished eating");
                    }

                }
            }
        };

        Timer timer = new Timer(name+" Eating Task");
        timer.schedule(timerTask, 30000);
    }

}
