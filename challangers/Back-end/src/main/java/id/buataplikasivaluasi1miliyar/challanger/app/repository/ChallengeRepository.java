package id.buataplikasivaluasi1miliyar.challanger.app.repository;

import id.buataplikasivaluasi1miliyar.challanger.app.entity.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Integer> {
}
