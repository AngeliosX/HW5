package com.hw5.feedback.service;

import com.hw5.feedback.entity.Shops;

public interface ShopsService {

    Shops getResponseFromShops(String response);
    Shops getDescriptionFromShops(String description);
    Shops getRatingFromShops(String rating);

}
