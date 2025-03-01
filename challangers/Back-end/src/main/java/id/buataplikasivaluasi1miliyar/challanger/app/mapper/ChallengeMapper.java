package id.buataplikasivaluasi1miliyar.challanger.app.mapper;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeSubDto;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.Challenge;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.ChallengeSub;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;
import java.util.List;

@Component
public class ChallengeMapper {

    // Convert dari Entity ke DTO untuk Challenge
    public ChallengeDto toDto(Challenge challenge) {
        return new ChallengeDto(
                challenge.getChallenge_id(),
                challenge.getChallenge_name(),
                challenge.getChallenge_description(),
                challenge.getChallenge_lavel(),
                challenge.getChallenge_participation(),
                challenge.getChallenge_participation_onprogress(),
                challenge.getChallenge_participation_finished(),
                challenge.getChallenge_participation_failed(),
                challenge.getCategoryId(),
                challenge.getCreate_at(),
                challenge.getUpdate_at(),
                challenge.getSubChallenges() != null
                        ? challenge.getSubChallenges().stream().map(this::toSubDto).collect(Collectors.toList())
                        : null
        );
    }

    // Convert dari Entity ke DTO untuk ChallengeSub
    public ChallengeSubDto toSubDto(ChallengeSub challengeSub) {
        return new ChallengeSubDto(
                challengeSub.getChallenge_sub_id(),
                challengeSub.getChallenge_sub_name(),
                challengeSub.getChallenge_sub_point()
        );
    }

    // Convert dari DTO ke Entity untuk Challenge
    public Challenge toEntity(ChallengeDto challengeDto) {
        Challenge challenge = new Challenge();
        challenge.setChallenge_id(challengeDto.getChallengeId());
        challenge.setChallenge_name(challengeDto.getChallengeName());
        challenge.setChallenge_description(challengeDto.getChallengeDescription());
        challenge.setChallenge_lavel(challengeDto.getChallengeLevel());
        challenge.setChallenge_participation(challengeDto.getChallengeParticipation());
        challenge.setChallenge_participation_onprogress(challengeDto.getChallengeParticipationOnProgress());
        challenge.setChallenge_participation_finished(challengeDto.getChallengeParticipationFinished());
        challenge.setChallenge_participation_failed(challengeDto.getChallengeParticipationFailed());
        challenge.setCategoryId(challengeDto.getCategoryId());
        challenge.setCreate_at(challengeDto.getCreatedAt());
        challenge.setUpdate_at(challengeDto.getUpdatedAt());

        // Konversi list sub-challenges dari DTO ke Entity
        if (challengeDto.getSubChallenges() != null) {
            List<ChallengeSub> subChallenges = challengeDto.getSubChallenges()
                    .stream()
                    .map(this::toSubEntity)
                    .collect(Collectors.toList());
            challenge.setSubChallenges(subChallenges);
        }

        return challenge;
    }

    // Convert dari DTO ke Entity untuk ChallengeSub
    public ChallengeSub toSubEntity(ChallengeSubDto challengeSubDto) {
        ChallengeSub challengeSub = new ChallengeSub();
        challengeSub.setChallenge_sub_id(challengeSubDto.getChallengeSubId());
        challengeSub.setChallenge_sub_name(challengeSubDto.getChallengeSubName());
        challengeSub.setChallenge_sub_point(challengeSubDto.getChallengeSubPoint());
        return challengeSub;
    }
}
