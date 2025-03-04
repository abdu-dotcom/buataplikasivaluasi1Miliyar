package id.buataplikasivaluasi1miliyar.challanger.app.mapper;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow.ProcessChallengeDto;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.UserChallengeProgress;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProcessChallengeMapper {
    ProcessChallengeMapper INSTANCE = Mappers.getMapper(ProcessChallengeMapper.class);

    @Mapping(source = "userChallengeId", target = "user_challange_id")
    @Mapping(source = "challengeSubId", target = "challenge_sub_id")
    @Mapping(source = "createAt", target = "create_at")
    ProcessChallengeDto toDto(UserChallengeProgress userChallengeProgress);

    @Mapping(source = "user_challange_id", target = "userChallengeId")
    @Mapping(source = "challenge_sub_id", target = "challengeSubId")
    @Mapping(source = "create_at", target = "createAt")
    UserChallengeProgress toEntity(ProcessChallengeDto processChallengeDto);

}
