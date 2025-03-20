package id.buataplikasivaluasi1miliyar.challanger.app.services.impl;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.*;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeJoin.ChallengeJoinRequestDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeJoin.ChallengeJoinResponseDto;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.Challenge;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.User;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.UserChallenge;
import id.buataplikasivaluasi1miliyar.challanger.app.exception.CustomExceptionHandler;
import id.buataplikasivaluasi1miliyar.challanger.app.mapper.ChallengeMapper;
import id.buataplikasivaluasi1miliyar.challanger.app.mapper.UserChallengeMapper;
import id.buataplikasivaluasi1miliyar.challanger.app.repository.ChallengeRepository;
import id.buataplikasivaluasi1miliyar.challanger.app.repository.UserChallengeRepository;
import id.buataplikasivaluasi1miliyar.challanger.app.services.UserChallengeService;
import id.buataplikasivaluasi1miliyar.challanger.app.utils.DateFormatter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserChallengeServiceImpl implements UserChallengeService {

    private static final Logger logger = LoggerFactory.getLogger(UserChallengeServiceImpl.class);

    private final ChallengeRepository challengeRepository;
    private final ChallengeMapper challengeMapper;
    private final UserChallengeRepository repository;
    private final UserChallengeMapper mapper;

    @Override
    public ChallengeJoinResponseDto acceptChallenge(ChallengeJoinRequestDto dto) {
        String isUserJoinedChallenge = isUserJoinedChallenge(dto);
        String userId = dto.getUserId();

        if (Objects.equals(isUserJoinedChallenge, "true")) {
      throw new CustomExceptionHandler.DuplicateDataException(
           userId, dto.getChallengeId());
        }

        int numberOfChallengeDay = repository.getNumberOfChallengeDaysByChallengeId(dto.getChallengeId());
        logger.info("=== [data numberOfChallengeDay] : [{}]", numberOfChallengeDay);

        LocalDateTime dateNow = LocalDateTime.now();
        LocalDateTime deadlineDate = dateNow.plusDays(numberOfChallengeDay);

        logger.info("=== [data dateNow]             : [{}]", dateNow);
        logger.info("=== [data deadlineDate]        : [{}]", deadlineDate);

        if (!userId.matches(".*\\d.*")) {
                throw new CustomExceptionHandler.BusinessException("Invalid userId format: " + userId);
        }
        Integer userIdNumber = Integer.valueOf(userId.replaceAll("\\D+", ""));
        Integer challengeId = dto.getChallengeId();
        String UserChallengeId = "CHL" + userIdNumber + challengeId;

        UserChallenge userChallenge = mapper.toUserChallengeEntity(dto);
        userChallenge.setUserChallengeId(UserChallengeId);
        userChallenge.setStatus("OnProgress");
        userChallenge.setJoinedat(dateNow);
        userChallenge.setDeadlinedat(deadlineDate);

        UserChallenge saveUserChallenge = repository.save(userChallenge);

        ChallengeJoinResponseDto userChallengeDto = mapper.toChallengeJoinResponsetDto(saveUserChallenge);
        userChallengeDto.setJoinedat(DateFormatter.formatDateTime(dateNow));

        return userChallengeDto;
    }


    public String isUserJoinedChallenge(ChallengeJoinRequestDto dto){
        // check di database
        return  repository.getUserChallengeByUserIdAndChallengeId(dto.getUserId(), dto.getChallengeId());
    };

    @Override
    public UserChallengeListResponseDTO getAllChallengesByUser(String userId) {

        UserChallengeListResponseDTO userChallengeListResponseDTO  = new UserChallengeListResponseDTO();

        // get data list userchallenger
        List<Object[]> results = repository.getUserChallengeStats(userId);
        List<UserChallengeDto> userChallengeList = new ArrayList<>();

        for (Object[] row : results) {
            // Ambil data user challenge

            UserChallengeDto userChallengeDto = new UserChallengeDto();
            userChallengeDto.setUserChallengeId((Integer) row[0]);
            userChallengeDto.setChallengeId((Integer) row[1]);
            userChallengeDto.setChallengeLevel((String) row[2]);
            userChallengeDto.setStatus((String) row[3]);
            userChallengeDto.setJoinedat(DateFormatter.formatDateTime(((Timestamp) row[4]).toLocalDateTime()));
            userChallengeDto.setFinishedat((row[5] != null ? DateFormatter.formatDateTime(((Timestamp) row[5]).toLocalDateTime()) : null));
            userChallengeDto.setDeadlinedat(DateFormatter.formatDateTime(((Timestamp) row[6]).toLocalDateTime()));
            userChallengeDto.setProgress((BigDecimal) row[7]);

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
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Challenge not found for this user.");
        }

        UserChallengeDetailDto userChallengeDetailDto = new UserChallengeDetailDto();

        // get challengeDetail Dto
        Optional<Challenge> challengeDetailOpt = challengeRepository.getChallengeById(challengeId);
    ChallengeDetailDto challengeDetailDto =
        challengeDetailOpt
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
