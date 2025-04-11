package id.buataplikasivaluasi1miliyar.challanger.app.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserChallengeListResponseDTO {
  private String userId;
  private List<UserChallengeDto> userChallenge;
}

