package com.soma.test.application.use_case;

import com.soma.test.builder.PriceBuilder;
import com.soma.test.domain.model.Price;
import com.soma.test.domain.repository.PriceRepository;
import com.soma.test.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceUseCaseImplTest {

    @InjectMocks
    private PriceUseCaseImpl priceUseCase;

    @Mock
    private PriceRepository priceRepository;

    @Test
    void when_use_case_is_called_object_is_returned() {
        when(this.priceRepository.find(any(), any(), any())).thenReturn(new PriceBuilder().build());
        Price price = priceUseCase.find(
                Timestamp.valueOf("2020-06-14 16:00:00"),
                111L,
                1L
        );

        assertEquals(new PriceBuilder().build(), price);
    }

}