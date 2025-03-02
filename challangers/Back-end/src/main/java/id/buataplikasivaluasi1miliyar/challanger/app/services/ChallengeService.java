package id.buataplikasivaluasi1miliyar.challanger.app.services;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeDetailDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeDto;

import java.util.List;

public interface ChallengeService {
    List<ChallengeDto> getChallengers();

    List<ChallengeDetailDto> getChallengeByCategoryId(Integer categori_id);

    ChallengeDetailDto getChallengeById(Integer challenge_id);
}
