package id.buataplikasivaluasi1miliyar.challanger.app.repository;

import id.buataplikasivaluasi1miliyar.challanger.app.entity.UserChallenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserChallengeRepository extends JpaRepository<UserChallenge, Integer> {
    @Query(value = """
        SELECT uc.user_id, u.username,
               c.challenge_id, c.challenge_name,
               cs.challenge_sub_id, cs.challenge_sub_name,
               cs.challenge_sub_point,
               cs.challenge_sub_tipe_deadline,
               cs.challenge_sub_deadline_time,
               ucp.status, ucp.started_at, 
               ucp.completed_at, ucp.deadline_at,
               ucp.caption, ucp.proof_url
        FROM user_challenges uc
        JOIN users u ON uc.user_id = u.user_id
        JOIN challenges c ON uc.challenge_id = c.challenge_id
        JOIN challenges_sub cs ON uc.challenge_id = cs.challenge_id
        LEFT JOIN user_challenges_progress ucp ON cs.challenge_sub_id = ucp.challenge_sub_id
        WHERE uc.user_id = :userId AND uc.challenge_id = :challengeId
    """, nativeQuery = true)
    List<Object[]> findUserChallengeDetail(@Param("userId") String userId, @Param("challengeId") Integer challengeId);
}
