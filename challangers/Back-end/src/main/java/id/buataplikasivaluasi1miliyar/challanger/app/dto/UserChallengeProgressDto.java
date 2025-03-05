package id.buataplikasivaluasi1miliyar.challanger.app.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder
public class UserChallengeProgressDto {
    private String status;
    private String caption;
    private String proofUrl;
    private LocalDateTime startedAt;
    private LocalDateTime deadlineAt;
    private LocalDateTime completedAt;
}
