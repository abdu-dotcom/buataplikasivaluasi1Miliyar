package id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeSubCompletion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChallengeSubCompletionRequest {
    private String userId;
    private String userChallengeId;
    private Integer subChallengeId;
    private String caption;
    private String proofUrl;
}
