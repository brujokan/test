package com.soma.test.domain.repository;

import com.soma.test.domain.model.Price;
import com.soma.test.exception.NotFoundException;

import java.sql.Timestamp;

public interface PriceRepository {

    public Price find(
            Timestamp date,
            Long productId,
            Long brandId
    ) throws NotFoundException;
}
