package id.buataplikasivaluasi1miliyar.challanger.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserChallengeDto {
    @Id
    private String userChallengeId;
    private Integer challengeId;
    private String challengeLevel;
    private String status; // on_progress, completed, failed
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String joinedat;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String finishedat;
    private String deadlinedat;
    private BigDecimal progress;
}
