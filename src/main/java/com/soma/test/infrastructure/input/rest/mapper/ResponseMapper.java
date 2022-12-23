package com.soma.test.infrastructure.input.rest.mapper;

import com.soma.test.application.PriceResponse;
import com.soma.test.domain.model.Price;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ResponseMapper {

    @Mapping(source = "price", target = "finalPrice")
    @Mapping(source = "priceList", target = "priceId")
    PriceResponse map(Price input);
}
