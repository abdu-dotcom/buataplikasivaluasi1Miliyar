package id.buataplikasivaluasi1miliyar.challanger.app.dto.ExploreMenu;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({
        "progressId", "userId", "username", "ChallengeName",
        "ChallengeSubName", "caption",
        "proofUrl", "finishedAt"
})
public class ExploreMenuDto {
    private String progressId;
    private String userId;
    private String username;
    private String ChallengeName;
    private String ChallengeLevel;
    private String ChallengeSubName;
    private String caption;
    private String proofUrl;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Jakarta")
    private Timestamp finishedAt;
}
