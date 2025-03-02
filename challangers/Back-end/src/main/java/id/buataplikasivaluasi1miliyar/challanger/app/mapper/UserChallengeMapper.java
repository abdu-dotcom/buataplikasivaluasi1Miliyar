package id.buataplikasivaluasi1miliyar.challanger.app.mapper;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.UserChallengeDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.UserResponse;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.UserChallenge;
import org.springframework.stereotype.Component;

@Component
public class UserChallengeMapper {

    public UserChallengeDto toDTO(UserChallenge challenge) {
        return new UserChallengeDto(
                challenge.getUserChallengeId(),
                challenge.getUserId(),
                challenge.getChallengeId(),
                challenge.getStatus(),
                challenge.getJoinedat(),
                challenge.getFinishedat(),
                challenge.getDeadlinedat()
        );
    }

    public UserChallenge toEntity(UserChallengeDto dto) {
        return new UserChallenge(
                dto.getUserChallengeId(),
                dto.getUserId(),
                dto.getChallengeId(),
                dto.getStatus(),
                dto.getJoinedat(),
                dto.getFinishedat(),
                dto.getDeadlinedat());
    }

}
