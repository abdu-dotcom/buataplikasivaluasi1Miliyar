package id.buataplikasivaluasi1miliyar.challanger.app.services.impl;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.*;
import id.buataplikasivaluasi1miliyar.challanger.app.exception.CustomExceptionHandler;
import id.buataplikasivaluasi1miliyar.challanger.app.mapper.ChallengeMapper;
import id.buataplikasivaluasi1miliyar.challanger.app.mapper.UserChallengeMapper;
import id.buataplikasivaluasi1miliyar.challanger.app.projection.UserChallengeProgressProjection;
import id.buataplikasivaluasi1miliyar.challanger.app.repository.ChallengeRepository;
import id.buataplikasivaluasi1miliyar.challanger.app.repository.UserChallengeRepository;
import id.buataplikasivaluasi1miliyar.challanger.app.services.UserChallengeService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserChallengeServiceImpl implements UserChallengeService {

    private static final Logger logger = LoggerFactory.getLogger(UserChallengeServiceImpl.class);

    private final ChallengeRepository challengeRepository;
    private final ChallengeMapper challengeMapper;
    private final UserChallengeMapper userChallengeMapper;
    private final UserChallengeRepository repository;

    /** Mendapat semua challenge yang diikutin user */
    @Override
    public UserChallengeListResponseDTO getAllChallengesByUser(String userId) {

        // get data list userchallenger
        List<Object[]> results = repository.getUserChallengeStats(userId);

        // object to dto
        List<UserChallengeDto> userChallengeList = results.stream()
                .map(userChallengeMapper::ObjectToUserChallengeDto)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        // return data
        return  UserChallengeListResponseDTO.builder()
                .userId(userId)
                .userChallenge(userChallengeList)
                .build();
    }

    /** Mendapatkan satu challenge beserta data lengkap yang diikutin user  */
    @Override
    public UserChallengeDetailDto getUserChallengeDetail(String userId, Integer challengeId) {
        List<UserChallengeProgressProjection> results = repository.findUserChallengeDetail(userId, challengeId);

        if (results.isEmpty()) {
            throw new CustomExceptionHandler.ResourceNotFoundException("Challenge not found for this user.");
        }

        ChallengeDetailDto challengeDetailDto = challengeRepository.getChallengeByChallengeId(challengeId)
                .map(challengeMapper::toChallengeDetailDto)
                .orElseThrow(() -> new IllegalArgumentException("Challenge not found"));

        // Ambil user info dari row pertama
        UserChallengeDetailDto userChallengeDetailDto = UserChallengeDetailDto.builder()
                .userId(results.get(0).getUserId())
                .username(results.get(0).getUsername())
                .challengeDetail(challengeDetailDto)
                .build();

        // Mapping list subChallenge + progress
        List<ChallengeSubDto> subChallenges = results.stream().map(row -> {
            UserChallengeProgressDto progress = (row.getStatus() != null)
                    ? UserChallengeProgressDto.builder()
                    .status(row.getStatus())
                    .startedAt(row.getStartedAt())
                    .completedAt(row.getCompletedAt())
                    .deadlineAt(row.getDeadlineAt())
                    .caption(row.getCaption())
                    .proofUrl(row.getProofUrl())
                    .build()
                    : UserChallengeProgressDto.builder()
                    .status("Locked")
                    .build();

            return ChallengeSubDto.builder()
                    .challengeSubId(row.getChallengeSubId())
                    .challengeSubName(row.getChallengeSubName())
                    .challengeSubPoint(row.getChallengeSubPoint())
                    .challengeSubTipeDeadline(row.getChallengeSubTipeDeadline())
                    .challengeSubDeadlineTime(row.getChallengeSubDeadlineTime())
                    .challengeSubProgress(progress)
                    .build();
        }).toList();

        challengeDetailDto.setSubChallenges(subChallenges);
        return userChallengeDetailDto;
    }
}
