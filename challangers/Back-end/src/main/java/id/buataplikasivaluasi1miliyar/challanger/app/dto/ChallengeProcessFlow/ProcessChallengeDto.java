package id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProcessChallengeDto {
    // data user challenge progress
    private Integer user_challange_id;
    private Integer challenge_sub_id;
    private String status;
    private LocalDateTime startedAt;
    private LocalDateTime completedAt;
    private LocalDateTime deadlineAt;
    private ActionProcessFlow actionProcessFlow;
}
