package com.soma.test.infrastructure.output.persistence.mapper;

import com.soma.test.domain.model.Price;
import com.soma.test.infrastructure.output.persistence.entity.PriceEntity;
import org.mapstruct.Mapper;

@Mapper
public interface EntityMapper {

    Price map(PriceEntity input);
}
