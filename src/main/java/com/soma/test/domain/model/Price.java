package com.soma.test.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Price {
    private Long priceList;
    private Long brandId;
    private Timestamp startDate;
    private Timestamp endDate;
    private Long productId;
    private Long priority;
    private Double price;
    private String curr;
}
