package id.buataplikasivaluasi1miliyar.challanger.app.dto.ExploreMenu;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExploreMenuDto {
    private Integer progressId;
    private String userId;
    private String username;
    private Integer userChallengeId;
    private Integer challengeSubId;
    private String caption;
    private String proofUrl;
    private LocalDateTime createAt;
}
