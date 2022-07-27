package com.example.coffeeShops.utils;

import org.junit.jupiter.api.Test;

import java.util.regex.PatternSyntaxException;

import static com.hw5.feedback.util.UtilForEmail.validationEmail;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class UtilEmailTest {
    @Test
    void validateEmailAddress() throws PatternSyntaxException {
        boolean validationEmail = validationEmail("test1@ru.com");
        assertTrue(validationEmail);
        validationEmail = validationEmail("test2#.com");
        assertFalse(validationEmail);
        validationEmail = validationEmail("test3@gmail.com");
        assertTrue(validationEmail);
        validationEmail = validationEmail("test4.@gmail.com");
        assertTrue(validationEmail);
        validationEmail = validationEmail("test5@ gmail");
        assertFalse(validationEmail);
        validationEmail = validationEmail("test6gmail");
        assertFalse(validationEmail);
        validationEmail = validationEmail("");
        assertFalse(validationEmail);
        validationEmail = validationEmail("test7@mail.ru");
        assertTrue(validationEmail);
    }
}
