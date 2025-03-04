package id.buataplikasivaluasi1miliyar.challanger.app.repository;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.ExploreMenu.ExploreMenuDto;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.UserChallengeProgress;
import id.buataplikasivaluasi1miliyar.challanger.app.projection.ExploreMenuProjection;
import id.buataplikasivaluasi1miliyar.challanger.app.projection.LeaderboardProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExploreMenuRepository extends JpaRepository<UserChallengeProgress, Integer> {

    @Query(value = """
     select
    	u.user_id as userId,
    	u.username as username,
    	ucp.progress_id as progressId,
    	ucp.user_challange_id as userChallengeId,
    	ucp.challenge_sub_id as challengeSubId,
    	ucp.caption as caption,
    	ucp.proof_url as proofUrl,
    	ucp.create_at as createAt
    from
    	user_challenges_progress ucp
    join user_challenges uc on
    	ucp.user_challange_id = uc.user_challange_id
    join users u on
    	uc.user_id = u.user_id
    """, nativeQuery = true)
    List<ExploreMenuProjection> findAllWithUserInfo();
}
