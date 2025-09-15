package com.sanjtiksha.site.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "product")   // ensure it maps to DB table
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double price;

    @Column(name = "amazon_link")
    private String amazonLink;

    @Column(name = "flipkart_link")
    private String flipkartLink;

    @Column(name = "meesho_link")
    private String meeshoLink;
}
