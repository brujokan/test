package com.soma.test.infrastructure.input.rest;

import com.soma.test.application.PriceApi;
import com.soma.test.application.PriceResponse;
import com.soma.test.domain.use_case.PriceUseCase;
import com.soma.test.infrastructure.input.rest.mapper.ResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
public class PriceController implements PriceApi {

    private PriceUseCase priceUseCase;
    private ResponseMapper responseMapper;

    @Autowired
    public PriceController(
            PriceUseCase priceUseCase,
            ResponseMapper responseMapper
    ) {
        this.priceUseCase = priceUseCase;
        this.responseMapper = responseMapper;
    }

    @Override
    public ResponseEntity<PriceResponse> find(String date, Long product, Long brand) {
        return ResponseEntity.ok(
                responseMapper.map(priceUseCase.find(Timestamp.valueOf(date), product, brand))
        );
    }
}
