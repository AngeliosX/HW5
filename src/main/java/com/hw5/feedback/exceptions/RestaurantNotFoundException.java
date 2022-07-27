package com.hw5.feedback.exceptions;

public class RestaurantNotFoundException extends Exception {
    private final Long restaurantId;

    public RestaurantNotFoundException(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }
}