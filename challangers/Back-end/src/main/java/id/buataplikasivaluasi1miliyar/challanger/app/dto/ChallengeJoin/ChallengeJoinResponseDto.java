package id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeJoin;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChallengeJoinResponseDto {
    private String userId;
    private Integer challengeId;
    private String status; // on_progress, completed, failed
    private String joinedat;
}
