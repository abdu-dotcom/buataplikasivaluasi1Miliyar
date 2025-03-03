package id.buataplikasivaluasi1miliyar.challanger.app.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
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
public class ChallengeDto {
    private Integer challengeId;
    private String challengeName;
    private String challengeDescription;
    private String challengeLevel;
    private Integer challengeParticipation;
    private Integer challengeParticipationOnProgress;
    private Integer challengeParticipationFinished;
    private Integer challengeParticipationFailed;
    private Integer categoryId;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
