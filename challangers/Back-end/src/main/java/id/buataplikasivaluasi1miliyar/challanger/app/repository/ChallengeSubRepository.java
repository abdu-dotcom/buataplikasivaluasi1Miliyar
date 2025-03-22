package id.buataplikasivaluasi1miliyar.challanger.app.repository;

import id.buataplikasivaluasi1miliyar.challanger.app.entity.ChallengeSub;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChallengeSubRepository extends JpaRepository<ChallengeSub, Integer> {
    List<ChallengeSub> getChallengesSubBychallengeSubId(Integer challengeSubId);
}
