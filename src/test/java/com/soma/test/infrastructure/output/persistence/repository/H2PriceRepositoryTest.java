package com.soma.test.infrastructure.output.persistence.repository;

import com.soma.test.builder.PriceBuilder;
import com.soma.test.domain.model.Price;
import com.soma.test.exception.NotFoundException;
import com.soma.test.infrastructure.output.persistence.entity.PriceEntity;
import com.soma.test.infrastructure.output.persistence.jpa.RepositoryJPA;
import com.soma.test.infrastructure.output.persistence.mapper.EntityMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class H2PriceRepositoryTest {

    @InjectMocks
    private H2PriceRepository h2PriceRepository;
    @Mock
    private RepositoryJPA repositoryJPA;
    @Mock
    private EntityMapper entityMapper;

    @Test
    void when_find_is_executed_data_is_retrieved() throws NotFoundException {
        when(this.repositoryJPA.findPrice(any(), any(), any())).thenReturn(getPriceResults());
        when(this.entityMapper.map(any())).thenReturn(new PriceBuilder().build());
        Price price = h2PriceRepository.find(
                Timestamp.valueOf("2020-06-14 16:00:00"),
                111L,
                1L
        );

        assertEquals(new PriceBuilder().build(), price);
    }

    @Test
    void when_find_is_executed_and_there_is_no_data_exception_is_thrown() {
        when(this.repositoryJPA.findPrice(any(), any(), any())).thenReturn(Collections.EMPTY_LIST);

        assertThrows(NotFoundException.class, () -> h2PriceRepository.find(
                Timestamp.valueOf("2020-06-14 16:00:00"),
                111L,
                1L
        ));
    }

    private List<PriceEntity> getPriceResults() {
        return List.of(
                PriceEntity.builder()
                        .price(10.00)
                        .brandId(1L)
                        .priceList(1L)
                        .curr("EUR")
                        .startDate(Timestamp.valueOf("2020-06-14 15:00:00"))
                        .endDate(Timestamp.valueOf("2020-06-14 18:30:00"))
                        .priority(1L)
                        .productId(111L)
                        .build(),
                PriceEntity.builder()
                        .price(10.00)
                        .brandId(1L)
                        .priceList(2L)
                        .curr("EUR")
                        .startDate(Timestamp.valueOf("2020-06-14 15:00:00"))
                        .endDate(Timestamp.valueOf("2020-06-14 18:30:00"))
                        .priority(0L)
                        .productId(111L)
                        .build()
        );
    }

}