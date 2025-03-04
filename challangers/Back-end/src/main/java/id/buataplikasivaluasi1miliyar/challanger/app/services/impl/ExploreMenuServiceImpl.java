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

        System.out.println("UserChallengeId : "+userChallengeProgress.get(0).getUserChallengeId());
        System.out.println("challengesubid : "+userChallengeProgress.get(0).getChallengeSubId());

        // entity to dto
        return exploreMenuMapper.toExploreMenuDto(userChallengeProgress);
    }
}
