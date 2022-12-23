package com.soma.test.infrastructure.output.persistence.repository;

import com.soma.test.domain.model.Price;
import com.soma.test.domain.repository.PriceRepository;
import com.soma.test.exception.NotFoundException;
import com.soma.test.infrastructure.output.persistence.jpa.RepositoryJPA;
import com.soma.test.infrastructure.output.persistence.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public class H2PriceRepository implements PriceRepository {

    private final RepositoryJPA repositoryJPA;
    private final EntityMapper mapper;

    static final String ERROR_NOT_FOUND = "Resource not found";

    @Autowired
    public H2PriceRepository(
            RepositoryJPA repositoryJPA,
            EntityMapper mapper
    ) {
        this.repositoryJPA = repositoryJPA;
        this.mapper = mapper;
    }

    @Override
    public Price find(Timestamp date, Long productId, Long brandId) {
        return mapper.map(
                repositoryJPA.findPrice(
                        date, productId, brandId
                ).stream().findFirst().orElseThrow(() -> new NotFoundException(ERROR_NOT_FOUND))
        );
    }
}
