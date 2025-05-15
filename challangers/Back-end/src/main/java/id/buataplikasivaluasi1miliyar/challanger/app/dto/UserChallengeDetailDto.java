package id.buataplikasivaluasi1miliyar.challanger.app.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder
@Builder
public class UserChallengeDetailDto {
    private String userId;
    private String username;
    private ChallengeDetailDto challengeDetail;

}
