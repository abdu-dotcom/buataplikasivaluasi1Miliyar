package id.buataplikasivaluasi1miliyar.challanger.app.services;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeJoin.ChallengeJoinRequestDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeJoin.ChallengeJoinResponseDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.UserChallengeDetailDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.UserChallengeListResponseDTO;

import java.util.List;

public interface UserChallengeService {
    ChallengeJoinResponseDto acceptChallenge(ChallengeJoinRequestDto dto);
    UserChallengeListResponseDTO getAllChallengesByUser(String userId);
    UserChallengeDetailDto getUserChallengeDetail(String userId, Integer challengeId);
}
