package id.buataplikasivaluasi1miliyar.challanger.app.services.impl;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.Leaderboard.LeaderboardDto;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.Leaderboard;
import id.buataplikasivaluasi1miliyar.challanger.app.mapper.LeaderboardMapper;
import id.buataplikasivaluasi1miliyar.challanger.app.projection.LeaderboardProjection;
import id.buataplikasivaluasi1miliyar.challanger.app.repository.LeaderboardRepository;
import id.buataplikasivaluasi1miliyar.challanger.app.repository.UserChallengeRepository;
import id.buataplikasivaluasi1miliyar.challanger.app.services.LeaderboardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LeaderboardServiceImpl implements LeaderboardService {

    private final LeaderboardRepository leaderboardRepository;
    private final LeaderboardMapper leaderboardMapper;

    public LeaderboardDto getLeaderboard(String userId) {
        List<LeaderboardProjection> leaderboard = leaderboardRepository.findTop100ByOrderByScoreDesc();
        Optional<LeaderboardProjection> userRank = leaderboardRepository.findUserRank(userId);

        return leaderboardMapper.toLeaderboardResponse(leaderboard, userRank);
    }
}
