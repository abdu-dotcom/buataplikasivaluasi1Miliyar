package id.buataplikasivaluasi1miliyar.challanger.app.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({
        "challengeId", "challengeName", "challengeDescription", "challengeLevel",
        "challengeParticipation", "challengeParticipationOnProgress", "challengeParticipationFinished",
        "challengeParticipationFailed", "categoryId", "createdAt", "updatedAt", "subChallenges"
})
public class ChallengeDetailDto extends ChallengeDto {
    private List<ChallengeSubDto> subChallenges;
}
