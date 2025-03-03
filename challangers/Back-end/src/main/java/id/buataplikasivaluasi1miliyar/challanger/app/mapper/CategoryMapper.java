package id.buataplikasivaluasi1miliyar.challanger.app.mapper;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.CategoryDto;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    @Mapping(target = "category_id", source = "categoryDto.category_id")
    @Mapping(target = "category_name", source = "categoryDto.category_name")
    @Mapping(target = "category_desc", source = "categoryDto.category_desc")
    @Mapping(target = "category_img", source = "categoryDto.category_img")
    Category mapToCategory(CategoryDto categoryDto);

    @Mapping(target = "category_id", source = "category.category_id")
    @Mapping(target = "category_name", source = "category.category_name")
    @Mapping(target = "category_desc", source = "category.category_desc")
    @Mapping(target = "category_img", source = "category.category_img")
    CategoryDto mapToCategoryDto(Category category);
}
