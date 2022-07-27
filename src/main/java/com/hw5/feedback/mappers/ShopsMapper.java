package com.hw5.feedback.mappers;

import com.hw5.feedback.dto.out.ShopsOutDTO;
import com.hw5.feedback.entity.Shops;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ShopsMapper {

    @Mappings({
//            @Mapping(source = "establishment", target = "null"),
//            @Mapping(source = "creation_date", target = "date"),
//            @Mapping(target = "description", source = ""),
//            @Mapping(target = "rating", source = ""),
//            @Mapping(target = "response", source = "")
    })
    ShopsOutDTO responseEntityToResponseDTO(Shops shops);
}
