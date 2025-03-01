package id.buataplikasivaluasi1miliyar.challanger.app.mapper;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.CategoryDto;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    // Convert UserDto into JPA Entity
    public Category mapToCategory(CategoryDto categoryDto){
        return new Category(
                categoryDto.getCategory_id(),
                categoryDto.getCategory_name(),
                categoryDto.getCategory_desc(),
                categoryDto.getCategory_img());
    }

    // Convert User JPA Entity into UserDto
    public CategoryDto mapToUserDto(Category category){
        return new CategoryDto(
            category.getCategory_id(),
                category.getCategory_name(),
                category.getCategory_desc(),
                category.getCategory_img()
        );
    };
}
