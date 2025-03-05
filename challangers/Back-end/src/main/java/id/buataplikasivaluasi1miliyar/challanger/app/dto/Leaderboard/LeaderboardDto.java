package id.buataplikasivaluasi1miliyar.challanger.app.dto.Leaderboard;

import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class LeaderboardDto {
    private String status;
    private String timestamp;
    private UserRank user_rank;
    private List<LeaderboardItem> leaderboard;


    @Data
    @Builder
    @AllArgsConstructor
    public static class LeaderboardItem {
        private int rank;
        private String user_id;
        private int score;
        private Timestamp record_at;
    }

    @Data
    @Builder
    @AllArgsConstructor
    public static class UserRank {
        private int rank;
        private String user_id;
        private int score;
        private Timestamp record_at;
    }
}