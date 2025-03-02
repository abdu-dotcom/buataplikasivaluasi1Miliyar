package id.buataplikasivaluasi1miliyar.challanger.app.dto;

import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserChallengeDto {
    @Id
    private Integer userChallengeId;
    private String userId;
    private Integer challengeId;
    private String status; // on_progress, completed, failed
    private LocalDateTime joinedat;
    private LocalDateTime finishedat;
    private LocalDateTime deadlinedat;
}
