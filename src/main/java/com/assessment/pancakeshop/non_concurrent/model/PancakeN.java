package com.assessment.pancakeshop.non_concurrent.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PancakeN {

    private Integer quantity;
    private Double price;
    private String name;
}
