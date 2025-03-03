package id.buataplikasivaluasi1miliyar.challanger.app.services.impl;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.CategoryDto;
import id.buataplikasivaluasi1miliyar.challanger.app.mapper.CategoryMapper;
import id.buataplikasivaluasi1miliyar.challanger.app.repository.CategoryRepository;
import id.buataplikasivaluasi1miliyar.challanger.app.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public List<CategoryDto> getCategories(){

        List<CategoryDto> categories = categoryRepository.findAll()
                .stream()
                .map(categoryMapper::mapToCategoryDto) // Konversi dari User ke UserDto
                .collect(Collectors.toList());

        return categories;
    }
}
