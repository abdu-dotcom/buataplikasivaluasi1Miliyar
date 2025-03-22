package id.buataplikasivaluasi1miliyar.challanger.app.services;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeDetailDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeDto;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.Challenge;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.ChallengeSub;

import java.util.List;
import java.util.Optional;

public interface ChallengeService {
    List<ChallengeDto> getChallengers();

    List<ChallengeDto> getChallengeByCategoryId(Integer categori_id);

    ChallengeDetailDto getChallengeById(Integer challenge_id);

    List<ChallengeSub> getChallengeSubById(Integer challengeSubId);
}
