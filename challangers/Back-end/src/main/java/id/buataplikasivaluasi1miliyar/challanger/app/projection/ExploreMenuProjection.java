package id.buataplikasivaluasi1miliyar.challanger.app.projection;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public interface ExploreMenuProjection {

    String getUserId();
    String getUsername();
    Integer getProgressId();
    Integer getUserChallengeId();
    Integer getChallengeSubId();
    String getCaption();
    String getProofUrl();
    LocalDateTime getStartAt();
}
