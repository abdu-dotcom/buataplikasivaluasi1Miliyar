package id.buataplikasivaluasi1miliyar.challanger.app.services.impl;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.CategoryDto;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.Category;
import id.buataplikasivaluasi1miliyar.challanger.app.mapper.CategoryMapper;
import id.buataplikasivaluasi1miliyar.challanger.app.repository.CategoryRepository;
import id.buataplikasivaluasi1miliyar.challanger.app.services.CategoryService;
import id.buataplikasivaluasi1miliyar.challanger.app.utils.LogVariableUtil;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public List<CategoryDto> getCategories(){
        List<Category> categories = categoryRepository.findAll();

        if (categories.isEmpty()) return Collections.emptyList(); // return list kosong
        logger.debug(LogVariableUtil.log("categories", categories));

        for (Category cat : categories) {
            System.out.println("Category ID : " + cat.getCategoryId());
            System.out.println("Category Name: " + cat.getCategoryName());
            System.out.println("Category description: " + cat.getCategoryDesc());
            System.out.println("Category Image: " + cat.getCategoryImg());
        }
        return categories.stream()
           .map(categoryMapper::mapToCategoryDto) // Konversi dari entity ke Dto
           .collect(Collectors.toList());

    }
}
