package id.buataplikasivaluasi1miliyar.challanger.app.services;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeDto;

import java.util.List;

public interface ChallengeService {
    List<ChallengeDto> getChallengers();

    List<ChallengeDto> getChallengeByCategoryId(Integer categori_id);

    ChallengeDto getChallengeById(Integer id);
}
