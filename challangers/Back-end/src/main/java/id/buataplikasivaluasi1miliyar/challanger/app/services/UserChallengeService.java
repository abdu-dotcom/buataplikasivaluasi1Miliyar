package id.buataplikasivaluasi1miliyar.challanger.app.services;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.UserChallengeDetailDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.UserChallengeListResponseDTO;

import java.util.List;

public interface UserChallengeService {
    UserChallengeListResponseDTO getAllChallengesByUser(String userId);
    UserChallengeDetailDto getUserChallengeDetail(String userId, Integer challengeId);
}
