package com.hw5.feedback.controller;

import com.hw5.feedback.entity.Shops;
import com.hw5.feedback.service.ShopsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopsController {
    private final ShopsService shopsService;

    public ShopsController(ShopsService shopsService) {
        this.shopsService = shopsService;
    }

    @GetMapping("/response")
    public Shops getResponseFromShops(String response) {
        return shopsService.getResponseFromShops(response);
    }


    @GetMapping("/description")
    public Shops getDescriptionFromShops(String description) {
        return shopsService.getDescriptionFromShops(description);
    }

    @GetMapping("/rating")
    public Shops getRatingFromShops(String rating) {
        return shopsService.getRatingFromShops(rating);
    }

}
