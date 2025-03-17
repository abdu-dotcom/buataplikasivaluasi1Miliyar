package id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeJoin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChallengeJoinRequestDto {
    private String userId;
    private Integer challengeId;
}
