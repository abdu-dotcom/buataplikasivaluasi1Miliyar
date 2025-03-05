package id.buataplikasivaluasi1miliyar.challanger.app.repository;

import id.buataplikasivaluasi1miliyar.challanger.app.entity.UserChallengeProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProcessChallengeRepository extends JpaRepository<UserChallengeProgress, Integer> {
  @Query(
      value ="""
        select user_id 
        from user_challenges_progress ucp 
        join user_challenges uc on ucp.user_challange_id  = uc.challenge_id
        WHERE uc.user_challange_id = :userChallengeId;
        """,nativeQuery = true)
  List<Object[]> getUserByuserChallengeId(Integer userChallengeId);
    }
