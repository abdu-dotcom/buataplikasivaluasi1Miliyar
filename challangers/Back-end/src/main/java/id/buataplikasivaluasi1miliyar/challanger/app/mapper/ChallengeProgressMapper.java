package id.buataplikasivaluasi1miliyar.challanger.app.mapper;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow.ChallengeSubCompletion.ChallengeSubCompletionResponse;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.UserChallengeProgress;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ChallengeProgressMapper {

    ChallengeProgressMapper INSTANCE = Mappers.getMapper(ChallengeProgressMapper.class);

    ChallengeSubCompletionResponse toChallengeSubCompletionResponse(UserChallengeProgress userChallengeProgress);

}
