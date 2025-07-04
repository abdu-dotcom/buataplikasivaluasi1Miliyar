package id.buataplikasivaluasi1miliyar.challanger.app.controllers;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.CategoryDto;
import id.buataplikasivaluasi1miliyar.challanger.app.services.CategoryService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CategoryController {

  private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

  private final CategoryService categoryService;

  @GetMapping("/categories")
  public ResponseEntity<List<CategoryDto>> getCategories() {
    logger.info("START  service : {} (API END POINT: {})", "getCategories", "/categories");

    List<CategoryDto> categories = categoryService.getCategories();

    logger.info("END    service : {} (API END POINT: {})", "getCategories", "/categories");
    return new ResponseEntity<>(categories, HttpStatus.OK);
  }

  @GetMapping("/java-version")
  public String getJavaVersion() {
    return System.getProperty("java.version");
  }
}
