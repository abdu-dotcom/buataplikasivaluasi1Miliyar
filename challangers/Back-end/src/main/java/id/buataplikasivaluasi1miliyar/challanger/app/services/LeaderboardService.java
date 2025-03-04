package id.buataplikasivaluasi1miliyar.challanger.app.services;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.Leaderboard.LeaderboardDto;

public interface LeaderboardService {
    LeaderboardDto getLeaderboard(String userId);
}
