package com.soma.test.builder;

import com.soma.test.domain.model.Price;

import java.sql.Timestamp;

public class PriceBuilder {

    public Price build() {
        return Price.builder()
                .price(10.00)
                .brandId(1L)
                .priceList(1L)
                .curr("EUR")
                .startDate(Timestamp.valueOf("2020-06-14 15:00:00"))
                .endDate(Timestamp.valueOf("2020-06-14 18:30:00"))
                .priority(1L)
                .productId(111L)
                .build();
    }
}
