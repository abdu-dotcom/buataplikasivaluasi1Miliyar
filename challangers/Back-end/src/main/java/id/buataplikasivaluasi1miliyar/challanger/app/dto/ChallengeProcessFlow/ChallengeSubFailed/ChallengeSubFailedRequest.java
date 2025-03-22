package id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow.ChallengeSubFailed;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChallengeSubFailedRequest {
    private String userId;
    private String userChallengeId;
    private Integer subChallengeId;
}
