package com.example.gorygo.mapper;

import com.example.gorygo.model.Image;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(config = MapperConfig.class)
public interface ImageMapper {
    @Named("imageFromId")
    default Image imageFromId(Long id) {
        if (id != null) {
            return new Image(id);
        }
        return null;
    }
}
