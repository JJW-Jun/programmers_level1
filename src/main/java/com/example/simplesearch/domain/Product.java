package com.example.simplesearch.domain;


import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private String productLink;

    @Column(nullable = false)
    private String productImage;

    @Column(nullable = false)
    private int lowestPrice;

    @Column(nullable = false)
    private int myprice;



    protected Product() {
    }

    public Product(ProductRequestDto requestDto) {
        this.productName = requestDto.getProductName();
        this.productLink = requestDto.getProductLink();
        this.lowestPrice = requestDto.getLowestPrice();
        this.productImage = requestDto.getProductImage();
        this.myprice = 0;
    }


    public void update(ProductMyPriceRequestDto requestDto) {
        this.myprice = requestDto.getPrice();
    }


}