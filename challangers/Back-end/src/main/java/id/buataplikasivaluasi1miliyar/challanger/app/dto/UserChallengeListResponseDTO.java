package id.buataplikasivaluasi1miliyar.challanger.app.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserChallengeListResponseDTO {
  private String userId;
  private List<UserChallengeDto> userChallenge;
}

