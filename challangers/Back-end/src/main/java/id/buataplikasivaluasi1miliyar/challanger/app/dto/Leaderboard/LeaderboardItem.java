package id.buataplikasivaluasi1miliyar.challanger.app.dto.Leaderboard;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LeaderboardItem {
    private int rank;
    private String user_id;
    private String username;
    private int score;
    private String record_at;
}
