package id.buataplikasivaluasi1miliyar.challanger.app.mapper;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.Leaderboard.LeaderboardDto;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.Leaderboard;
import id.buataplikasivaluasi1miliyar.challanger.app.projection.LeaderboardProjection;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface LeaderboardMapper {
    default LeaderboardDto toLeaderboardResponse(List<LeaderboardProjection> leaderboard, Optional<LeaderboardProjection> userRank) {
        List<LeaderboardDto.LeaderboardItem> leaderboardList = leaderboard.stream()
                .map(entry -> new LeaderboardDto.LeaderboardItem(
                        entry.getRank(),
                        entry.getUserId(),
                        entry.getScore(),
                        entry.getRecordAt()
                ))
                .collect(Collectors.toList());

        LeaderboardDto.UserRank userRankData = userRank.map(entry ->
                new LeaderboardDto.UserRank(entry.getRank(), entry.getUserId(), entry.getScore(), entry.getRecordAt())
        ).orElse(null);

        return new LeaderboardDto("success", Instant.now().toString(), userRankData,leaderboardList);
    }
}