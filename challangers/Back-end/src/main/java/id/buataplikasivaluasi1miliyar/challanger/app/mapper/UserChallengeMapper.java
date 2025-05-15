package id.buataplikasivaluasi1miliyar.challanger.app.mapper;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow.ChallengeJoin.ChallengeJoinRequestDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow.ChallengeJoin.ChallengeJoinResponseDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.UserChallengeDto;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.UserChallenge;
import org.mapstruct.Mapper;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Mapper(componentModel = "spring")
public interface UserChallengeMapper {

    // mapper untuk end point /accept-challenge
    ChallengeJoinResponseDto toChallengeJoinResponsetDto(UserChallenge challenge);
    UserChallenge toUserChallengeEntity(ChallengeJoinRequestDto dto);

    // ✨ Tambahkan ini
    default UserChallengeDto ObjectToUserChallengeDto(Object[] row) {
        if (row == null || row.length < 9) return null;

        return UserChallengeDto.builder()
            .userChallengeId((String) row[0])
            .challengeId((Integer) row[1])
            .challengeName((String) row[2])
            .challengeLevel((String) row[3])
            .status((String) row[4])
            .joinedat((Timestamp) row[5])
            .finishedat(row[6] != null ? (Timestamp) row[6] : null)
            .deadlinedat((Timestamp) row[7])
            .progress((BigDecimal) row[8])
            .build();
    }
}
