package id.buataplikasivaluasi1miliyar.challanger.app.repository;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeDetailDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeDto;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.Challenge;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.ChallengeSub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Integer> {
    Optional<Challenge> getChallengeByChallengeId(Integer challengeId);

  @Query(
      value = """
        select challenge_sub_point
        from challenges_sub cs 
        where cs.challenge_sub_id  = :challengeId;
      """, nativeQuery = true)
  Integer getChallengeSubPointById(Integer challengeId);

    List<Challenge> findByCategoryId(Integer categoryId);

    @Query(value = """
    select challenge_sub_point from challenges_sub cs where cs.challenge_id = :challengeId and cs.challenge_sub_id = :challengeSubId
  """, nativeQuery = true)
    Integer getScoreByIdAndChallengeSubId(@Param("challengeId") Integer challengeId,@Param("challengeSubId")  Integer challengeSubId);


}
