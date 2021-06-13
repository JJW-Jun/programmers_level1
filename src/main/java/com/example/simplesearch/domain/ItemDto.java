package com.example.simplesearch.domain;

import lombok.Getter;
import org.json.JSONObject;

@Getter
public class ItemDto {
    private String productName;
    private String productLink;
    private String productImage;
    private int lowestPrice;

    public ItemDto(JSONObject itemJson) {
        this.productName = itemJson.getString("title");
        this.productLink = itemJson.getString("link");
        this.productImage = itemJson.getString("image");
        this.lowestPrice = itemJson.getInt("lprice");
    }
}