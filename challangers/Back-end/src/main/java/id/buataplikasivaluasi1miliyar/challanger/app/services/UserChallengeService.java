package id.buataplikasivaluasi1miliyar.challanger.app.services;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.UserChallengeDto;

import java.util.List;

public interface UserChallengeService {
    UserChallengeDto acceptChallenge(UserChallengeDto dto);
    List<UserChallengeDto> getAllChallengesByUser(String userId);
}
