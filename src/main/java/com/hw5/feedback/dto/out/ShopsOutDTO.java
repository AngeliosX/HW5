package com.hw5.feedback.dto.out;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShopsOutDTO {
    private Long id;
    private String establishment;
    private String description;
    private String response;
    private String rating;
    private LocalDate creation_date;
}