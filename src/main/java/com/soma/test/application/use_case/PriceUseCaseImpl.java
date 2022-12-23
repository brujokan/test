package com.soma.test.application.use_case;

import com.soma.test.domain.model.Price;
import com.soma.test.domain.repository.PriceRepository;
import com.soma.test.domain.use_case.PriceUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class PriceUseCaseImpl implements PriceUseCase {

    private PriceRepository priceRepository;

    @Autowired
    public PriceUseCaseImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public Price find(Timestamp date, Long productId, Long brandId) {
        return priceRepository.find(date, productId, brandId);
    }
}
