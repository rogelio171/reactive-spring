package com.roger.reactivespring.controller;

import com.roger.reactivespring.model.Purchase;
import com.roger.reactivespring.service.CoinBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/coin/purchase/v1")
public class PurchaseController {

    @Autowired
    private CoinBaseService coinBaseService;

    @PostMapping("/{name}")
    public Mono<Purchase> createPurchase(@PathVariable String name) {
        return coinBaseService.createPurchase(name);
    }
}
