package com.example.coffeeShops.service;

import com.example.coffeeShops.AppContextTest;
import com.hw5.feedback.service.ShopsService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShopsServiceTest {
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    static
    class ResponseServiceTest extends AppContextTest {
        private Long shopsWithResponse;
        private Long shopsWithDescription;

        private Long shopsWithoutResponse;
        private Long shopsWithoutDescription;

        @Autowired
        ShopsService shopsService;


        @BeforeAll
        void response() {
            String SHOPS_WITH_RESPONSE = "shop1";
            shopsWithResponse = shopsService.getResponseFromShops(SHOPS_WITH_RESPONSE).getId();
            String SHOPS_WITHOUT_RESPONSE = "shop2";
            shopsWithoutResponse = shopsService.getResponseFromShops(SHOPS_WITHOUT_RESPONSE).getId();
        }

        @AfterAll
        void description() {
            String SHOPS_WITH_DESCRIPTION = "shop3";
            shopsWithDescription = shopsService.getResponseFromShops(SHOPS_WITH_DESCRIPTION).getId();
            String SHOPS_WITHOUT_DESCRIPTION = "shop4";
            shopsWithoutDescription = shopsService.getResponseFromShops(SHOPS_WITHOUT_DESCRIPTION).getId();
        }


        @Test
        void getResponseFromShops(String response) {
            shopsService.getResponseFromShops(response);
            assertEquals(1, shopsWithResponse);
            assertEquals(2, shopsWithoutResponse);
        }

        @Test
        void getDescriptionFromShops(String description) {
            shopsService.getDescriptionFromShops(description);
            assertEquals(3, shopsWithDescription);
            assertEquals(4, shopsWithoutDescription);
        }
    }
}
