package id.buataplikasivaluasi1miliyar.challanger.app.services.impl;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.ExploreMenu.ExploreMenuDto;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.UserChallengeProgress;
import id.buataplikasivaluasi1miliyar.challanger.app.mapper.ExploreMenuMapper;
import id.buataplikasivaluasi1miliyar.challanger.app.mapper.LeaderboardMapper;
import id.buataplikasivaluasi1miliyar.challanger.app.projection.ExploreMenuProjection;
import id.buataplikasivaluasi1miliyar.challanger.app.repository.ExploreMenuRepository;
import id.buataplikasivaluasi1miliyar.challanger.app.services.ExploreMenuService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ExploreMenuServiceImpl implements ExploreMenuService {

    private final ExploreMenuMapper exploreMenuMapper;
    private final ExploreMenuRepository exploreMenuRepository;

    @Override
    public List<ExploreMenuDto> getProgresAllUsers() {
        List<ExploreMenuProjection>  userChallengeProgress = exploreMenuRepository.findAllWithUserInfo();

        // entity to dto
        return exploreMenuMapper.toExploreMenuDto(userChallengeProgress);
    }

    @Override
    public List<ExploreMenuDto> getProgressAUser(String userId) {
        List<ExploreMenuProjection>  userChallengeProgress = exploreMenuRepository.findProgressByUserId(userId);

        // entity to dto
        return exploreMenuMapper.toExploreMenuDto(userChallengeProgress);
    }
}
