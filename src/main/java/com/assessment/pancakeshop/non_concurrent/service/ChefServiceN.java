package com.assessment.pancakeshop.non_concurrent.service;

import com.assessment.pancakeshop.concurrent.model.Pancake;
import com.assessment.pancakeshop.concurrent.model.User;
import com.assessment.pancakeshop.non_concurrent.model.PancakeN;
import com.assessment.pancakeshop.non_concurrent.model.UserN;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Getter
@Setter
@Slf4j
public class ChefServiceN {
    private List<PancakeN> pancakesN = new ArrayList<>();
    public void bakePancake(UserN userN) {
        if (Objects.equals(userN.getRole(), "Chef")) {
            log.info("Pancake Baking has Started");
            for (int i = 1; i <= 12; i++) {
                PancakeN pancakeN = PancakeN.builder()
                        .name("Pancake " + i)
                        .price(500.00)
                        .quantity(1)
                        .build();
                pancakesN.add(pancakeN);
            }
            log.info("Pancake Baking has Ended");
        }
    }

}
