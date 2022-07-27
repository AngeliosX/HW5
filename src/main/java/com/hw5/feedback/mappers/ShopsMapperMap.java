package com.hw5.feedback.mappers;

import com.google.i18n.phonenumbers.NumberParseException;
import com.hw5.feedback.dto.in.ShopsInDTO;
import com.hw5.feedback.dto.out.ShopsOutDTO;
import com.hw5.feedback.entity.Shops;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class ShopsMapperMap {
    @Autowired
    private ShopsMapper shopsMapper;

    public abstract ShopsOutDTO responseEntityToResponseDTO(Shops shops);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creation_date",
            expression = "java(org.example.restaurant.util.Util.reformatRuTelephone(restaurant.getTelephoneNumber()))"
    )
    public abstract Shops restaurantInDTOToRestaurantEntity(ShopsInDTO shops) throws NumberParseException;
    ShopsOutDTO reviewEntityToReviewOutDTO(Shops shops) {
        return shopsMapper.responseEntityToResponseDTO(shops);
    }

}
