package id.buataplikasivaluasi1miliyar.challanger.app.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({
        "challengeId", "challengeName", "challengeDescription", "challengeLevel",
        "challengeParticipation", "challengeParticipationOnProgress", "challengeParticipationFinished",
        "challengeParticipationFailed", "categoryId", "createdAt", "updatedAt"
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Jakarta")
    private Timestamp createdAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Jakarta")
    private Timestamp updatedAt;
}
