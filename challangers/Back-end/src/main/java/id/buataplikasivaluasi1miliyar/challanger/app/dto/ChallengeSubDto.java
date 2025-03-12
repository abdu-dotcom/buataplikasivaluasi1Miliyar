package id.buataplikasivaluasi1miliyar.challanger.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
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
    private Integer challengeSubId;
    private String  challengeSubName;
    private Integer challengeSubPoint;
    private String  challengeSubTipeDeadline;
    private Integer challengeSubDeadlineTime;


    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UserChallengeProgressDto challengeSubProgress;
}
