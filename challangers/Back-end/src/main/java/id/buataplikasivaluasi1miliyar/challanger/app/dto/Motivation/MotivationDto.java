package id.buataplikasivaluasi1miliyar.challanger.app.dto.Motivation;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MotivationDto {
    @Id
    private Integer motivationId;
    private String motivationQuotes;
    private String motivationAuthor;
}
