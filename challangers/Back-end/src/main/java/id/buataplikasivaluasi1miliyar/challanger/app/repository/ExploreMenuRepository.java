package id.buataplikasivaluasi1miliyar.challanger.app.repository;

import id.buataplikasivaluasi1miliyar.challanger.app.entity.UserChallengeProgress;
import id.buataplikasivaluasi1miliyar.challanger.app.projection.ExploreMenuProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExploreMenuRepository extends JpaRepository<UserChallengeProgress, Integer> {
    @Query(value = """
        select
            u.user_id as UserId,
            u.username as Username,
            ucp.progress_id as progressId,
            c.challenge_name as ChallengeName,
            c.challenge_level as ChallengeLevel,
            cs.challenge_sub_name as ChallengeSubName,
            ucp.caption as caption,
            ucp.proof_url as ProofUrl,
            ucp.completed_at as finishedAt
        from
            user_challenges_progress ucp
        join user_challenges uc on
            ucp.user_challange_id = uc.user_challange_id	
        left join challenges c on uc.challenge_id = c.challenge_id
        left join challenges_sub cs on uc.challenge_id = cs.challenge_id and ucp.challenge_sub_id = cs.challenge_sub_id
        join users u on uc.user_id = u.user_id 
        where ucp.status in ('Completed','Failed');
    """, nativeQuery = true)
    List<ExploreMenuProjection> findAllWithUserInfo();


  @Query(
      value =
          """
    select
        u.user_id as UserId,
        u.username as Username,
        ucp.progress_id as progressId,
        c.challenge_name as ChallengeName,
        c.challenge_level as ChallengeLevel,
        cs.challenge_sub_name as ChallengeSubName,
        ucp.caption as caption,
        ucp.proof_url as ProofUrl,
        ucp.completed_at as finishedAt
    from
        user_challenges_progress ucp
    join user_challenges uc on
        ucp.user_challange_id = uc.user_challange_id
    left join challenges c on uc.challenge_id = c.challenge_id
    left join challenges_sub cs on uc.challenge_id = cs.challenge_id and ucp.challenge_sub_id = cs.challenge_sub_id
    join users u on uc.user_id = u.user_id
    where uc.user_id = :userId and ucp.status in ('Completed','Failed');
    """,
      nativeQuery = true)
  List<ExploreMenuProjection> findProgressByUserId(String userId);
}
