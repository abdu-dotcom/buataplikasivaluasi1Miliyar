package id.buataplikasivaluasi1miliyar.challanger.app.services.impl;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.*;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.Challenge;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.ChallengeSub;
import id.buataplikasivaluasi1miliyar.challanger.app.exception.CustomExceptionHandler;
import id.buataplikasivaluasi1miliyar.challanger.app.mapper.ChallengeMapper;
import id.buataplikasivaluasi1miliyar.challanger.app.repository.ChallengeRepository;
import id.buataplikasivaluasi1miliyar.challanger.app.repository.ChallengeSubRepository;
import id.buataplikasivaluasi1miliyar.challanger.app.repository.UserChallengeRepository;
import id.buataplikasivaluasi1miliyar.challanger.app.services.UserChallengeService;
import id.buataplikasivaluasi1miliyar.challanger.app.utils.DateFormatter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

@Service
@RequiredArgsConstructor
public class UserChallengeServiceImpl implements UserChallengeService {

    private static final Logger logger = LoggerFactory.getLogger(UserChallengeServiceImpl.class);

    private final ChallengeRepository challengeRepository;
    private final ChallengeMapper challengeMapper;
    private final UserChallengeRepository repository;

    @Override
    public UserChallengeListResponseDTO getAllChallengesByUser(String userId) {

        UserChallengeListResponseDTO userChallengeListResponseDTO  = new UserChallengeListResponseDTO();

        // get data list userchallenger
        List<Object[]> results = repository.getUserChallengeStats(userId);
        List<UserChallengeDto> userChallengeList = new ArrayList<>();

        for (Object[] row : results) {
            // Ambil data user challenge

            UserChallengeDto userChallengeDto = new UserChallengeDto();
            userChallengeDto.setUserChallengeId((String) row[0]);
            userChallengeDto.setChallengeId((Integer) row[1]);
            userChallengeDto.setChallengeName((String) row[2]);
            userChallengeDto.setChallengeLevel((String) row[3]);
            userChallengeDto.setStatus((String) row[4]);
            userChallengeDto.setJoinedat(DateFormatter.formatDateTime(((Timestamp) row[5]).toLocalDateTime()));
            userChallengeDto.setFinishedat((row[6] != null ? DateFormatter.formatDateTime(((Timestamp) row[6]).toLocalDateTime()) : null));
            userChallengeDto.setDeadlinedat(DateFormatter.formatDateTime(((Timestamp) row[7]).toLocalDateTime()));
            userChallengeDto.setProgress((BigDecimal) row[8]);

            userChallengeList.add(userChallengeDto);
        }

        userChallengeListResponseDTO.setUserId(userId);
        userChallengeListResponseDTO.setUserChallenge(userChallengeList);

        return userChallengeListResponseDTO;
    }

    @Override
    public UserChallengeDetailDto getUserChallengeDetail(String userId, Integer challengeId) {
        List<Object[]> results = repository.findUserChallengeDetail(userId, challengeId);

        if (results.isEmpty()) {
            throw new CustomExceptionHandler.ResourceNotFoundException(
            "Challenge not found for this user.");
        }

        UserChallengeDetailDto userChallengeDetailDto = new UserChallengeDetailDto();

        // get challengeDetail Dto
        Optional<Challenge> challengeDetailOpt = challengeRepository.getChallengeById(challengeId);

        ChallengeDetailDto challengeDetailDto = challengeDetailOpt
            .map(challengeMapper::toChallengeDetailDto)
            .orElseThrow(() -> new IllegalArgumentException("Challenge not found"));

        List<ChallengeSubDto> subChallenges = new ArrayList<>();

        for (Object[] row : results) {
            // Ambil data user
            userChallengeDetailDto.setUserId((String) row[0]);
            userChallengeDetailDto.setUsername((String) row[1]);

            // Ambil data sub-challenge
            ChallengeSubDto subChallenge = new ChallengeSubDto();
            subChallenge.setChallengeSubId((Integer) row[4]);
            subChallenge.setChallengeSubName((String) row[5]);
            subChallenge.setChallengeSubPoint((Integer) row[6]);
            subChallenge.setChallengeSubTipeDeadline((String) row[7]);
            subChallenge.setChallengeSubDeadlineTime((Integer) row[8]);

            // Ambil progress detail (bisa null)
            UserChallengeProgressDto progressDetail = null;
            if (row[9] != null) {
                progressDetail = new UserChallengeProgressDto();
                progressDetail.setStatus((String) row[9]);
                progressDetail.setStartedAt(row[10] != null ? DateFormatter.formatDateTime(((Timestamp) row[10]).toLocalDateTime()) : null);
                progressDetail.setCompletedAt(row[11] != null ? DateFormatter.formatDateTime(((Timestamp) row[11]).toLocalDateTime()) : null);
                progressDetail.setDeadlineAt(row[12] != null ? DateFormatter.formatDateTime(((Timestamp) row[12]).toLocalDateTime()) : null);
                progressDetail.setCaption((String) row[13]);
                progressDetail.setProofUrl((String) row[14]);
            } else{
                progressDetail = new UserChallengeProgressDto();
                progressDetail.setStatus("Locked");
            }
            subChallenge.setChallengeSubProgress(progressDetail);

            subChallenges.add(subChallenge);
        }

        challengeDetailDto.setSubChallenges(subChallenges);
        userChallengeDetailDto.setChallengeDetail(challengeDetailDto);

        return userChallengeDetailDto;
    }

}
