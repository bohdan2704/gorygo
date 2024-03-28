package com.example.gorygo.mapper;

import com.example.gorygo.dto.get.CategoryDto;
import com.example.gorygo.dto.post.CreateCategoryDto;
import com.example.gorygo.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(config = MapperConfig.class, uses = ImageMapper.class)
public interface CategoryMapper {
//    @Mapping(target = "imageId", source = "image.id")
    @Mapping(target = "upperId", source = "upper.id")
    CategoryDto toDto(Category category);

//    @Mapping(target = "image", source = "imageId", qualifiedByName = "imageFromId")
    @Mapping(target = "upper", source = "upperId", qualifiedByName = "categoryFromId")
    Category toModel(CreateCategoryDto createCategoryDto);

    @Named("categoryFromId")
    default Category categoryFromId(Long id) {
        if (id != null) {
            return new Category(id);
        }
        return null;
    }
}
