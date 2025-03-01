package id.buataplikasivaluasi1miliyar.challanger.app.mapper;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.UserRequest;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.UserResponse;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.Challenge;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.User;
import org.springframework.stereotype.Component;

@Component
public class ChallengeMapper {

    // Convert UserDto into JPA Entity | Response
    public Challenge toEntity(ChallengeDto challengeDto){

        return new Challenge(
                challengeDto.getChallenge_id(),
                challengeDto.getChallenge_name(),
                challengeDto.getChallenge_description(),
                challengeDto.getChallenge_lavel(),
                challengeDto.getChallenge_participation(),
                challengeDto.getChallenge_participation_onprogress(),
                challengeDto.getChallenge_participation_finished(),
                challengeDto.getChallenge_participation_failed(),
                challengeDto.getCategori_id(),
                challengeDto.getCreate_at(),
                challengeDto.getUpdate_at());
    }

    // Convert UserRequest DTO ke User Entity
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
            challenge.getCategori_id(),
            challenge.getCreate_at(),
            challenge.getUpdate_at()
    );
    };

}
