package com.soma.test.domain.use_case;

import com.soma.test.domain.model.Price;
import com.soma.test.exception.NotFoundException;

import java.sql.Timestamp;

public interface PriceUseCase {

    public Price find(
            Timestamp date,
            Long productId,
            Long brandId
    ) throws NotFoundException;
}
