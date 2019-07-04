package com.roger.reactivespring.service;

import com.roger.reactivespring.model.CoinBaseResponse;
import com.roger.reactivespring.model.Purchase;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CoinBaseService {

    Mono<CoinBaseResponse> getCryptoPrice(String priceName);

    Mono<Purchase> createPurchase(String priceName);

    Mono<Purchase> getPurchaseById(String id);

    Flux<Purchase> listAllPurchases();

}
