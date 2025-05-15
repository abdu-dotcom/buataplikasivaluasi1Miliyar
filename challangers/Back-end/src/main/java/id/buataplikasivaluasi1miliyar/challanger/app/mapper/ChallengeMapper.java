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

    Challenge toChallengeEntity(ChallengeDto challengeDto);

    @InheritInverseConfiguration
    ChallengeDto toChallengeDto(Challenge challenge);

    Challenge toChallengeDetailEntity(ChallengeDetailDto challengeDetailDto);
    ChallengeDetailDto toChallengeDetailDto(Challenge challenge);

    List<ChallengeDetailDto> toChallengeDetailDtoList(List<Challenge> challenges);

    ChallengeSub toSubEntity(ChallengeSubDto challengeSubDto);

    @InheritInverseConfiguration
    ChallengeSubDto toSubDto(ChallengeSub challengeSub);

    List<ChallengeSubDto> toSubDtoList(List<ChallengeSub> subChallenges);
    List<ChallengeSub> toSubEntityList(List<ChallengeSubDto> subChallengeDtos);
}
