package com.roger.reactivespring.service;

import com.roger.reactivespring.model.CoinBaseResponse;
import com.roger.reactivespring.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class CoinBaseServiceImpl implements CoinBaseService {

    @Autowired
    private WebClient webClient;

    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    @Override
    public Mono<CoinBaseResponse> getCryptoPrice(String priceName) {
        return webClient.get()
                .uri("https://api.coinbase.com/v2/prices/{crypto}/buy", priceName)
                .exchange()
                .flatMap(clientResponse -> clientResponse.bodyToMono(CoinBaseResponse.class));
    }

    @Override
    public Mono<Purchase> createPurchase(String priceName) {
        return getCryptoPrice(priceName).flatMap(price -> reactiveMongoTemplate.save(
                new Purchase(priceName, price.getData().getAmount(), LocalDateTime.now())
        ));
    }

    @Override
    public Mono<Purchase> getPurchaseById(String id) {
        return reactiveMongoTemplate.findById(id, Purchase.class);
    }

    @Override
    public Flux<Purchase> listAllPurchases() {
        return reactiveMongoTemplate.findAll(Purchase.class);
    }
}
