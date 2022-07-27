package com.example.coffeeShops.utils;

import com.hw5.feedback.exceptions.FoundationDateIsExpiredException;
import com.hw5.feedback.exceptions.RestaurantNotFoundException;
import com.hw5.feedback.service.ShopsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.mockStatic;

public class UtilDateTest {
    @Autowired
    private ShopsService shopsService;

    @Test
    void createShop() throws FoundationDateIsExpiredException, RestaurantNotFoundException {
        MockedStatic<LocalDate> localDateMockedStatic = mockStatic(LocalDate.class, CALLS_REAL_METHODS);
        LocalDate defaultNow = LocalDate.of(2018, 7, 8);
        localDateMockedStatic.when(LocalDate::now).thenReturn(defaultNow);

        Assertions.assertThrowsExactly(FoundationDateIsExpiredException.class,
                () -> shopsService.createShopByNameAndDate("shop6", LocalDate.of(2018, 7, 7)),
                "Restaurant with name \"" + "test" + "\"" +
                        "has foundation date " + LocalDate.now().plusDays(0));

        long test = shopsService.createShopByNameAndDate("shop7", LocalDate.of(2018, 7, 7));
        LocalDate creation_date = shopsService.getCreation_date(test);
        assertEquals(LocalDate.of(2018, 7, 7), creation_date);
    }
}
