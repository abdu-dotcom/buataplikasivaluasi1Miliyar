package id.buataplikasivaluasi1miliyar.challanger.app.services.impl;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow.ActionProcessFlow;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow.ProcessChallengeDto;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.Challenge;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.ChallengeSub;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.Leaderboard;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.UserChallengeProgress;
import id.buataplikasivaluasi1miliyar.challanger.app.mapper.LeaderboardMapper;
import id.buataplikasivaluasi1miliyar.challanger.app.mapper.ProcessChallengeMapper;
import id.buataplikasivaluasi1miliyar.challanger.app.projection.LeaderboardProjection;
import id.buataplikasivaluasi1miliyar.challanger.app.repository.ChallengeRepository;
import id.buataplikasivaluasi1miliyar.challanger.app.repository.LeaderboardRepository;
import id.buataplikasivaluasi1miliyar.challanger.app.repository.ProcessChallengeRepository;
import id.buataplikasivaluasi1miliyar.challanger.app.services.ProcessChallengeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProcessChallengeServiceImpl implements ProcessChallengeService {

    private ChallengeRepository challengeRepository;
    private LeaderboardRepository leaderboardRepository;
    private ProcessChallengeRepository processChallengeRepository;
    private ProcessChallengeMapper processChallengeMapper;
    private LeaderboardMapper leaderboardMapper;

    @Override
    public ProcessChallengeDto startChallenge(ProcessChallengeDto request) {
        // dto to entity
        UserChallengeProgress userChallengeProgressData = processChallengeMapper.toEntity(request);

        userChallengeProgressData.setStatus("on_prgoress");
        userChallengeProgressData.setStartedAt(LocalDateTime.now());
        userChallengeProgressData.setDeadlineAt(LocalDateTime.now().plusDays(10));
        // save
        UserChallengeProgress saved = processChallengeRepository.save(userChallengeProgressData);

        // set actionProcessFlow
        ActionProcessFlow actionProcessFlow = new  ActionProcessFlow();
        actionProcessFlow.setTextActionProcess("sub challenge is start!");

        // entity to dto
        ProcessChallengeDto startChallengeDto =  processChallengeMapper.toDto(saved);
        startChallengeDto.setActionProcessFlow(actionProcessFlow);
        return startChallengeDto;
    }

    @Override
    public ProcessChallengeDto complateUserChallengeProgress(Integer progressId, ProcessChallengeDto requestComplateProgress) {
        Optional<UserChallengeProgress> existingProgressOpt = processChallengeRepository.findById(progressId);
        UserChallengeProgress existingProgress = null;
        ProcessChallengeDto processChallengeDto = null;

        // update progress challenge user set completed.
        UserChallengeProgress saved = null;
        if (existingProgressOpt.isPresent()) {

            // update data leaderboard
            addScoreToLeaderboard(requestComplateProgress);

            // update complete data
            existingProgress = existingProgressOpt.get();
            existingProgress.setStatus(requestComplateProgress.getStatus());
            existingProgress.setCaption("Custom Caption");
            existingProgress.setProofUrl("https:google.com");
            existingProgress.setStatus("Complate");

            // set actionProcessFlow
            ActionProcessFlow actionProcessFlow = new  ActionProcessFlow();
            actionProcessFlow.setTextActionProcess("sub challenge is complated!");

            processChallengeDto = processChallengeMapper.toDto(existingProgress);
            processChallengeDto.setActionProcessFlow(actionProcessFlow);

            saved = processChallengeRepository.save(existingProgress);
        } else {
            throw new RuntimeException("UserChallengeProgress not found");
        }



        return processChallengeDto;
    }

    public void addScoreToLeaderboard(ProcessChallengeDto requestComplateProgress){

        String userId = requestComplateProgress.getUser_Id();
        Integer challengeSubId = requestComplateProgress.getChallenge_sub_id();

        System.out.println("userId: " + userId);
        System.out.println("challengeSubId: " + challengeSubId);

        /** menghituing point untuk update ke leaderboard **/

        // get old leaderboard
        Optional<LeaderboardProjection> LeaderboardUser = leaderboardRepository.findUserRank(userId);

        Integer leaderboardId = LeaderboardUser.get().getLeaderboardId();
        Integer scoreRank = LeaderboardUser.get().getScore();

        // get score challenge sub
        Integer scoreChallengeSubPoint = challengeRepository.getChallengeSubPointById(challengeSubId);
        System.out.println("scoreChallengeSubPoint: " + scoreChallengeSubPoint);

        // sum score rank
        scoreRank = scoreRank + scoreChallengeSubPoint;

        // update score to leader board
        Leaderboard newLeaderboard = new Leaderboard();
        newLeaderboard.setLeaderboard_id(leaderboardId);
        newLeaderboard.setUser_id(userId);
        newLeaderboard.setScore(scoreRank);
        newLeaderboard.setRecord_at(LocalDateTime.now());

        /** Update data score rank leaderboard **/
        leaderboardRepository.save(newLeaderboard);
    }

}
