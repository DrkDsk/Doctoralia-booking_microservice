package com.example.bookingmicroservice.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Entity
@Table(name = "items")
@Setter
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private BigDecimal price;

    @Column(name = "`created_at`")
    @CreationTimestamp
    private Date timestampCreatedAt;

    @Column(name = "`updated_at`")
    @CreationTimestamp
    private Date timestampUpdatedAt;
}
