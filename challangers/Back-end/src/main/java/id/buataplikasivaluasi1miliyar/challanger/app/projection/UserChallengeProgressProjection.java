package id.buataplikasivaluasi1miliyar.challanger.app.projection;

import java.sql.Timestamp;

public interface UserChallengeProgressProjection {
        String getUserId();
        String getUsername();

        Integer getChallengeSubId();
        String getChallengeSubName();
        Integer getChallengeSubPoint();
        String getChallengeSubTipeDeadline();
        Integer getChallengeSubDeadlineTime();

        String getStatus();
        Timestamp getStartedAt();
        Timestamp getCompletedAt();
        Timestamp getDeadlineAt();
        String getCaption();
        String getProofUrl();
    }
