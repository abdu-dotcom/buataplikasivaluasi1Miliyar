package id.buataplikasivaluasi1miliyar.challanger.app.projection;

import java.sql.Timestamp;

public interface LeaderboardProjection {
    String getUserId();
    String getUsername();
    Integer getScore();
    Timestamp getRecordAt();
    Integer getRank();
}
