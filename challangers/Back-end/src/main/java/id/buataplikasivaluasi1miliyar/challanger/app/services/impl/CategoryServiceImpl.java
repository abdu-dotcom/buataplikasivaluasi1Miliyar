package id.buataplikasivaluasi1miliyar.challanger.app.services.impl;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.CategoryDto;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.Category;
import id.buataplikasivaluasi1miliyar.challanger.app.exception.CustomExceptionHandler;
import id.buataplikasivaluasi1miliyar.challanger.app.mapper.CategoryMapper;
import id.buataplikasivaluasi1miliyar.challanger.app.repository.CategoryRepository;
import id.buataplikasivaluasi1miliyar.challanger.app.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public List<CategoryDto> getCategories(){
           List<Category> categories = categoryRepository.findAll();

           if (categories.isEmpty()) return Collections.emptyList(); // Jangan return null, return list kosong

           return categories.stream()
                   .map(categoryMapper::mapToCategoryDto) // Konversi dari User ke UserDto
                   .collect(Collectors.toList());
    }
}
