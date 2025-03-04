package id.buataplikasivaluasi1miliyar.challanger.app.repository;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow.StartChallengeDto;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.UserChallengeProgress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessChallengeRepository extends JpaRepository<UserChallengeProgress, Integer> {
    }
