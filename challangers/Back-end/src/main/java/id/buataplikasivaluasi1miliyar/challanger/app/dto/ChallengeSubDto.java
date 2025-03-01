package id.buataplikasivaluasi1miliyar.challanger.app.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@JsonPropertyOrder
public class ChallengeSubDto {
    @Id
    private int challengeSubId;
    private String challengeSubName;
    private int challengeSubPoint;
}
