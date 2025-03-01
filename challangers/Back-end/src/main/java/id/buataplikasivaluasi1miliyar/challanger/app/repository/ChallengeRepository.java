package id.buataplikasivaluasi1miliyar.challanger.app.repository;

import id.buataplikasivaluasi1miliyar.challanger.app.entity.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Integer> {
    List<Challenge> findByCategoryId(Integer categoryId);
}
