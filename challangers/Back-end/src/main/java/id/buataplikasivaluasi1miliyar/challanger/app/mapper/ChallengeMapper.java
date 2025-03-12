package id.buataplikasivaluasi1miliyar.challanger.app.mapper;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeDetailDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeSubDto;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.Challenge;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.ChallengeSub;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ChallengeMapper {

    ChallengeMapper INSTANCE = Mappers.getMapper(ChallengeMapper.class);

    @Mapping(source = "challengeId", target = "id")
    @Mapping(source = "challengeName", target = "challenge_name")
    @Mapping(source = "challengeDescription", target = "challenge_description")
    @Mapping(source = "challengeLevel", target = "challenge_level")
    @Mapping(source = "challengeParticipation", target = "challenge_participation")
    @Mapping(source = "challengeParticipationOnProgress", target = "challenge_participation_onprogress")
    @Mapping(source = "challengeParticipationFinished", target = "challenge_participation_finished")
    @Mapping(source = "challengeParticipationFailed", target = "challenge_participation_failed")
    @Mapping(source = "categoryId", target = "categoryId")
    @Mapping(source = "createdAt", target = "create_at")
    @Mapping(source = "updatedAt", target = "update_at")
    Challenge toChallengeEntity(ChallengeDto challengeDto);

    @InheritInverseConfiguration
    ChallengeDto toChallengeDto(Challenge challenge);

    @Mapping(source = "challengeId", target = "id")
    @Mapping(source = "subChallenges", target = "subChallenges")
    Challenge toChallengeDetailEntity(ChallengeDetailDto challengeDetailDto);

    @Mapping(source = "id", target = "challengeId")
    @Mapping(source = "challenge_name", target = "challengeName")
    @Mapping(source = "challenge_description", target = "challengeDescription")
    @Mapping(source = "challenge_level", target = "challengeLevel")
    @Mapping(source = "challenge_participation", target = "challengeParticipation")
    @Mapping(source = "challenge_participation_onprogress", target = "challengeParticipationOnProgress")
    @Mapping(source = "challenge_participation_finished", target = "challengeParticipationFinished")
    @Mapping(source = "challenge_participation_failed", target = "challengeParticipationFailed")
    @Mapping(source = "create_at", target = "createdAt")
    @Mapping(source = "update_at", target = "updatedAt")
    @Mapping(source = "subChallenges", target = "subChallenges")
    ChallengeDetailDto toChallengeDetailDto(Challenge challenge);

    List<ChallengeDetailDto> toChallengeDetailDtoList(List<Challenge> challenges);

    @Mapping(source = "challengeSubId", target = "challenge_sub_id")
    @Mapping(source = "challengeSubName", target = "challenge_sub_name")
    @Mapping(source = "challengeSubPoint", target = "challenge_sub_point")
    @Mapping(source = "challengeSubTipeDeadline", target = "challenge_sub_tipe_deadline")
    @Mapping(source = "challengeSubDeadlineTime", target = "challenge_sub_deadline_time")
    ChallengeSub toSubEntity(ChallengeSubDto challengeSubDto);

    @InheritInverseConfiguration
    ChallengeSubDto toSubDto(ChallengeSub challengeSub);

    List<ChallengeSubDto> toSubDtoList(List<ChallengeSub> subChallenges);
    List<ChallengeSub> toSubEntityList(List<ChallengeSubDto> subChallengeDtos);
}
