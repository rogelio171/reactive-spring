package com.roger.reactivespring.controller;

import com.roger.reactivespring.model.CoinBaseResponse;
import com.roger.reactivespring.service.CoinBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/coin/price/v1")
public class PriceController {

    @Autowired
    private CoinBaseService coinBaseService;

    @GetMapping("/{name}")
    public Mono<CoinBaseResponse> getPrice(@PathVariable String name) {
        return coinBaseService.getCryptoPrice(name);
    }
}
