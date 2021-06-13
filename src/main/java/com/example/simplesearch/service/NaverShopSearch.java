package com.example.simplesearch.service;


import com.example.simplesearch.domain.ItemDto;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

@Component
public class NaverShopSearch {


    public String searchKeyword(String keyword) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://openapi.naver.com/v1/search/shop.json?query=" + keyword)
                .method("GET", null)
                .addHeader("X-Naver-Client-Id", "naver")
                .addHeader("X-Naver-Client-Secret", "password")
                .build();

        Response response = client.newCall(request).execute();

        return Objects.requireNonNull(response.body()).string();
    }


    public List<ItemDto> fromJsonToItems(String result) {
        JSONObject rjson = new JSONObject(result);
        JSONArray items = rjson.getJSONArray("items");
        List<ItemDto> itemDtoList = new ArrayList<>();
        for (int i = 0; i < items.length(); i++) {
            JSONObject item = items.getJSONObject(i);
            ItemDto itemDto = new ItemDto(item);
            itemDtoList.add(itemDto);
        }
        return itemDtoList;
    }

    public static void main(String[] args) throws IOException {
        NaverShopSearch ns = new NaverShopSearch();
        ns.searchKeyword("iphone");
        System.out.println("===============");
    }
}
