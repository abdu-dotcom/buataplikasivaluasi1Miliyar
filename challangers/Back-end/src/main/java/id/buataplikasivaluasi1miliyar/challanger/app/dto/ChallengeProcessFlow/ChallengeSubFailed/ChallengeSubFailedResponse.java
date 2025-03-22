package id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow.ChallengeSubFailed;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChallengeSubFailedResponse extends Message {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String userId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String userChallengeId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer subChallengeId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String status; // on_progress, completed, failed

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Jakarta")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Timestamp complatedAt;
}
