package id.buataplikasivaluasi1miliyar.challanger.app.projection;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public interface ExploreMenuProjection {

    String getUserId();
    String getUsername();
    String getProgressId();
    String getChallengeName();
    String getChallengeLevel();
    String getChallengeSubName();
    String getCaption();
    String getProofUrl();
    Timestamp getFinishedAt();
}
