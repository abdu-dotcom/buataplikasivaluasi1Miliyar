package id.buataplikasivaluasi1miliyar.challanger.app.repository;

import id.buataplikasivaluasi1miliyar.challanger.app.entity.Leaderboard;
import id.buataplikasivaluasi1miliyar.challanger.app.projection.LeaderboardProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LeaderboardRepository extends JpaRepository<Leaderboard, Integer> {
    @Query(value = """
    SELECT
        l.user_id AS userId,
        u.username as username,
        l.score AS score, 
        l.record_at AS recordAt, 
        DENSE_RANK() OVER (ORDER BY l.score DESC) AS rank 
    FROM leaderboard l left join users u on l.user_id = u.user_id
    LIMIT 100
    """, nativeQuery = true)
    List<LeaderboardProjection> findTop100ByOrderByScoreDesc();

      @Query(value ="""
      SELECT userId, username, score, recordAt, rank FROM (
            SELECT
                l.user_id AS userId,
                u.username AS username,
                l.score AS score,
                l.record_at AS recordAt,
                DENSE_RANK() OVER (ORDER BY l.score DESC) AS rank
            FROM leaderboard l left join users u on l.user_id = u.user_id
        ) ranked
        WHERE ranked.userId = :userId
    """,nativeQuery = true)
  Optional<LeaderboardProjection> findUserRank(@Param("userId") String userId);
}
