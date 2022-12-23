package com.soma.test.infrastructure.output.persistence.jpa;

import com.soma.test.infrastructure.output.persistence.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;

public interface RepositoryJPA extends JpaRepository<PriceEntity, Long> {

    @Query("select p " +
            "from PriceEntity p " +
            "where p.startDate <= ?1 " +
            "and p.endDate >= ?1 " +
            "and p.productId = ?2 " +
            "and p.brandId = ?3 " +
            "order by p.priority desc")
    List<PriceEntity> findPrice(
            Timestamp date,
            Long productId,
            Long brandId
    );
}
