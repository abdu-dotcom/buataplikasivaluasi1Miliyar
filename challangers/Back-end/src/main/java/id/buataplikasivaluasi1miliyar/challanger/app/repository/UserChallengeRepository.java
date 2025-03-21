package id.buataplikasivaluasi1miliyar.challanger.app.repository;

import id.buataplikasivaluasi1miliyar.challanger.app.entity.User;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.UserChallenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserChallengeRepository extends JpaRepository<UserChallenge, String> {
  @Query(
      value =
          """
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
        LEFT JOIN user_challenges_progress ucp on uc.user_challange_id = ucp.user_challange_id
            AND cs.challenge_sub_id = ucp.challenge_sub_id\s
        WHERE uc.user_id = :userId AND uc.challenge_id = :challengeId
    """,
      nativeQuery = true)
  List<Object[]> findUserChallengeDetail(
      @Param("userId") String userId, @Param("challengeId") Integer challengeId);

  @Query(
      value = """
          select count(*) as numberOfChallengeDays from challenges_sub cs where cs.challenge_id = :challengeId;
        """,nativeQuery = true)
  Integer getNumberOfChallengeDaysByChallengeId(Integer challengeId);

  @Query(value = """
          select CASE
                  WHEN count(*) > 0 THEN 'true'
                  ELSE 'false'
              END AS isUserJoinedChallenge from user_challenges uc
              where uc.user_id  = :userId and uc.challenge_id = :challengeId;
""",nativeQuery = true)
  String getUserChallengeByUserIdAndChallengeId(@Param("userId") String userId, @Param("challengeId") Integer challengeId);

  @Query(value = """
    select
          uc.user_challange_id as userChallengeId,
          cs.challenge_id as challengeId,
          c.challenge_level as challengeLevel,
          uc.status,
          uc.joined_at as joinedat,
          uc.finished_at as finishedat,
          uc.deadline_at as deadlinedat,
          CEIL((COUNT(case when ucp.status in ('on_progress', 'finished') then 1 end) * 100.0 / nullif(COUNT(cs.challenge_sub_id),
          0))) as progress
      from
          user_challenges uc
          inner join challenges c on uc.challenge_id = c.challenge_id
      inner join challenges_sub cs\s
          on
          uc.challenge_id = cs.challenge_id
      left join user_challenges_progress ucp\s
          on
          uc.user_challange_id = ucp.user_challange_id
          and cs.challenge_sub_id = ucp.challenge_sub_id
      where
          uc.user_id = :userId
      group by
          uc.user_id,
          uc.user_challange_id,
          cs.challenge_id,
          c.challenge_level,
          uc.status,
          uc.joined_at,
          uc.finished_at,
          uc.deadline_at
    """,
      nativeQuery = true)
  List<Object[]> getUserChallengeStats(@Param("userId") String userId);

    UserChallenge getChallengeIdByUserChallengeId(String userChallengeId);

    UserChallenge getUserChallengeByUserChallengeId(String userChallengeId);
  }
