package id.buataplikasivaluasi1miliyar.challanger.app.mapper;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.CategoryDto;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDto mapToCategoryDto(Category category);

    List<CategoryDto> mapToCategoryDtoList(List<Category> categories); // ← Tambahkan ini
}
