package com.asps.graphqlcatalog.dto.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCourseInput {
    private String name;
    private String description;
    private Long categoryId;
    private LocalDate startDate;
    private BigDecimal monthlyFee;
}
