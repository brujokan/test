package com.soma.test.infrastructure.output.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "price")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PriceEntity {
    @Id
    @Column(name = "price_list")
    private Long priceList;
    @Column(name = "brand_id")
    private Long brandId;
    @Column(name = "start_date")
    private Timestamp startDate;
    @Column(name = "end_date")
    private Timestamp endDate;
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "priority")
    private Long priority;
    @Column(name = "price")
    private Double price;
    @Column(name = "curr")
    private String curr;
}
