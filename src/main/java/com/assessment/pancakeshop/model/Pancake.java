package com.assessment.pancakeshop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pancake {
    private Integer quantity;
    private Double price;
    private String name;
}
