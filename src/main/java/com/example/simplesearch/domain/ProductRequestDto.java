package com.example.simplesearch.domain;

import lombok.Getter;

@Getter
public class ProductRequestDto {
    private String productName;
    private String productLink;
    private String productImage;
    private int lowestPrice;
}
