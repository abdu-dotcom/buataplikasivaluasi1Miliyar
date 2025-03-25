package id.buataplikasivaluasi1miliyar.challanger.app.dto.Leaderboard;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class LeaderboardDto {
    private UserRank user_rank;
    private List<LeaderboardItem> leaderboard;


    @Data
    @Builder
    @AllArgsConstructor
    public static class LeaderboardItem {
        private int rank;
        private String user_id;
        private int score;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Jakarta")
        private Timestamp record_at;
    }

    @Data
    @Builder
    @AllArgsConstructor
    public static class UserRank {
        private int rank;
        private String user_id;
        private int score;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Jakarta")
        private Timestamp record_at;
    }
}