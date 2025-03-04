package id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow;

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
    private LocalDateTime create_at;
    private String status;

    private ActionProcessFlow actionProcessFlow;
}
