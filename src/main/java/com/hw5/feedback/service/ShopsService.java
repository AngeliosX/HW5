package com.hw5.feedback.service;

import com.hw5.feedback.entity.Shops;
import com.hw5.feedback.exceptions.FoundationDateIsExpiredException;
import com.hw5.feedback.exceptions.RestaurantNotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface ShopsService {

    Shops getResponseFromShops(String response);
    Shops getDescriptionFromShops(String description);
    Shops getRatingFromShops(String rating);

    long createShopByNameAndDate(String name, LocalDate creation_date) throws FoundationDateIsExpiredException;
    LocalDate getCreation_date(Long id) throws RestaurantNotFoundException;
}
