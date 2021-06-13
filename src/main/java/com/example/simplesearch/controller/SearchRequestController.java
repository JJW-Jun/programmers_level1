package com.example.simplesearch.controller;

import com.example.simplesearch.domain.ItemDto;
import com.example.simplesearch.service.NaverShopSearch;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class SearchRequestController {

    private final NaverShopSearch naverShopSearch;

    @GetMapping("/api/search")
    public List<ItemDto> executeSearch(@RequestParam String query) throws IOException{
        String result = naverShopSearch.searchKeyword(query);
        return naverShopSearch.fromJsonToItems(result);
    }
}
