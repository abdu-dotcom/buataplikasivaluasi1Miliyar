package id.buataplikasivaluasi1miliyar.challanger.app.mapper;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeJoin.ChallengeJoinRequestDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeJoin.ChallengeJoinResponseDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.UserChallengeDto;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.UserChallenge;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserChallengeMapper {

    UserChallengeMapper INSTANCE = Mappers.getMapper(UserChallengeMapper.class);

    @Mapping(source = "userChallengeId", target = "userChallengeId")
    @Mapping(source = "challengeId", target = "challengeId")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "joinedat", target = "joinedat")
    @Mapping(source = "finishedat", target = "finishedat")
    @Mapping(source = "deadlinedat", target = "deadlinedat")
    UserChallengeDto toDTO(UserChallenge challenge);

    @InheritInverseConfiguration
    UserChallenge toEntity(UserChallengeDto dto);

    // mapper untuk end point /accept-challenge
    ChallengeJoinResponseDto toChallengeJoinResponsetDto(UserChallenge challenge);
    UserChallenge toUserChallengeEntity(ChallengeJoinRequestDto dto);

}
