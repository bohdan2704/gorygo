package com.example.gorygo.mapper;

import com.example.gorygo.dto.get.ProductDto;
import com.example.gorygo.dto.post.CreateProductDto;
import com.example.gorygo.model.*;
import org.mapstruct.*;
import java.util.List;

@Mapper(config = MapperConfig.class, uses = CategoryMapper.class)
public interface ProductMapper {
    @Mapping(target = "sizeIds", ignore = true)
    @Mapping(target = "imageIds", ignore = true)
    @Mapping(target = "reviewIds", ignore = true)
    @Mapping(target = "questionIds", ignore = true)
    @Mapping(target = "categoryId", source = "category.id")
    ProductDto toDto(Product model);

    @AfterMapping
    default void initIdsFromObjects(@MappingTarget ProductDto dto,
                                      Product model) {
        List<Long> sizeIds = model.getSizes()
                .stream()
                .map(MeasurementValue::getId)
                .toList();

        List<Long> imageIds = model.getImages()
                .stream()
                .map(Image::getId)
                .toList();

        List<Long> reviewIds = model.getReviews()
                .stream()
                .map(Review::getId)
                .toList();

        List<Long> questionIds = model.getQuestions()
                .stream()
                .map(Question::getId)
                .toList();

        dto.setSizeIds(sizeIds);
        dto.setImageIds(imageIds);
        dto.setReviewIds(reviewIds);
        dto.setQuestionIds(questionIds);
    }

    @Mapping(target = "sizes", ignore = true)
    @Mapping(target = "images", ignore = true)
    @Mapping(target = "reviews", ignore = true)
    @Mapping(target = "questions", ignore = true)
    @Mapping(target = "category", source = "categoryId", qualifiedByName = "categoryFromId")
    Product toModel(CreateProductDto createDto);

    @AfterMapping
    default void initObjectsFromIds(@MappingTarget Product model,
                                     CreateProductDto createDto) {
        List<MeasurementValue> sizeObjectDummies = createDto.sizeIds()
                .stream()
                .map(MeasurementValue::new)
                .toList();
        model.setSizes(sizeObjectDummies);

        List<Image> imageObjectDummies = createDto.imageIds()
                .stream()
                .map(Image::new)
                .toList();
        model.setImages(imageObjectDummies);

        List<Review> reviewObjectDummies = createDto.reviewIds()
                .stream()
                .map(Review::new)
                .toList();
        model.setReviews(reviewObjectDummies);

        List<Question> questionObjectDummies = createDto.questionIds()
                .stream()
                .map(Question::new)
                .toList();
        model.setQuestions(questionObjectDummies);
    }

    CreateProductDto fromDtoToCreateDto(ProductDto dto);
}
