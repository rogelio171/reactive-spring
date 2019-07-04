package com.roger.reactivespring.controller;

import com.roger.reactivespring.model.Purchase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PurchaseControllerTest {

    @Autowired
    ApplicationContext applicationContext;

    private WebTestClient webTestClient;

    @Before
    public void setUp() {
        webTestClient = WebTestClient
                .bindToApplicationContext(this.applicationContext)
                .build();
    }

    @Test
    public void createPurchase() {

        webTestClient.get()
                .uri("/coin/purchase/v1/{id}", 123)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Purchase.class);
    }
}