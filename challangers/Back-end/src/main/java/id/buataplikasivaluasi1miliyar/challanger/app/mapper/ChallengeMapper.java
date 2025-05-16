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

    @InheritInverseConfiguration
    ChallengeDto toChallengeDto(Challenge challenge);

    ChallengeDetailDto toChallengeDetailDto(Challenge challenge);

    // Tambahkan ini: untuk mapping data challengeSub
    ChallengeSubDto toChallengeSubDto(ChallengeSub challengeSub);
}
