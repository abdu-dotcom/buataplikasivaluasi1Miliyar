package id.buataplikasivaluasi1miliyar.challanger.app.dto;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    private Integer categoryId;
    private String categoryName;
    private String categoryDesc;
    private String categoryImg;
}
