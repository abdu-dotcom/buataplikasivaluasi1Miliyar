package id.buataplikasivaluasi1miliyar.challanger.app.repository;

import id.buataplikasivaluasi1miliyar.challanger.app.entity.UserChallengeProgress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChallengeProgressRepository extends JpaRepository<UserChallengeProgress, String> {
    UserChallengeProgress findByUserChallengeIdAndChallengeSubId(String userChallengeId, Integer ChallengeSubId);
}
