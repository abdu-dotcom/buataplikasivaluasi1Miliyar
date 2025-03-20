package id.buataplikasivaluasi1miliyar.challanger.app.services.impl;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeJoin.ChallengeJoinRequestDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeJoin.ChallengeJoinResponseDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeSubCompletion.ChallengeSubCompletionRequest;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeSubCompletion.ChallengeSubCompletionResponse;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.Challenge;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.UserChallenge;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.UserChallengeProgress;
import id.buataplikasivaluasi1miliyar.challanger.app.exception.CustomExceptionHandler;
import id.buataplikasivaluasi1miliyar.challanger.app.mapper.ChallengeProgressMapper;
import id.buataplikasivaluasi1miliyar.challanger.app.mapper.UserChallengeMapper;
import id.buataplikasivaluasi1miliyar.challanger.app.repository.ChallengeProgressRepository;
import id.buataplikasivaluasi1miliyar.challanger.app.repository.ChallengeRepository;
import id.buataplikasivaluasi1miliyar.challanger.app.repository.UserChallengeRepository;
import id.buataplikasivaluasi1miliyar.challanger.app.services.ChallengeProgressService;
import id.buataplikasivaluasi1miliyar.challanger.app.utils.DateFormatter;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class ChallengeProgressServiceImpl implements ChallengeProgressService {

    private static final Logger logger = LoggerFactory.getLogger(ChallengeProgressServiceImpl.class);

    private ChallengeProgressRepository challengeProgressRepository;
    private ChallengeProgressMapper challengeProgressMapper;
    private final UserChallengeRepository userChallengeRepository;
    private final UserChallengeMapper userChallengeMapper;
    @Override
    public ChallengeJoinResponseDto acceptChallenge(ChallengeJoinRequestDto dto) {

        String isUserJoinedChallenge = userChallengeRepository.getUserChallengeByUserIdAndChallengeId(dto.getUserId(), dto.getChallengeId());
        String userId = dto.getUserId();

        // Cek apakah user sudah menerima challenge ini sebelumnya
        if (Objects.equals(isUserJoinedChallenge, "true"))
            throw new CustomExceptionHandler.DuplicateDataException(userId, dto.getChallengeId());

        int numberOfChallengeDay = userChallengeRepository.getNumberOfChallengeDaysByChallengeId(dto.getChallengeId());
        LocalDateTime dateNow = LocalDateTime.now();
        LocalDateTime deadlineDate = dateNow.plusDays(numberOfChallengeDay);

        if (!userId.matches(".*\\d.*"))
            throw new CustomExceptionHandler.BusinessException("Invalid userId format: " + userId);

        Integer userIdNumber = Integer.valueOf(userId.replaceAll("\\D+", ""));
        Integer challengeId = dto.getChallengeId();
        String UserChallengeId = "CHL" + userIdNumber + challengeId;

        // Buat entry di user_challenge
        UserChallenge userChallenge = userChallengeMapper.toUserChallengeEntity(dto);
        userChallenge.setUserChallengeId(UserChallengeId);
        userChallenge.setStatus("OnProgress");
        userChallenge.setJoinedat(dateNow);
        userChallenge.setDeadlinedat(deadlineDate);
        UserChallenge saveUserChallenge = userChallengeRepository.save(userChallenge);

        String progresId = UserChallengeId + 1;

        // Insert ke user_challenge_progress untuk sub-challenge pertama
        UserChallengeProgress progress = new UserChallengeProgress();
        progress.setProgressId(progresId);
        progress.setUserChallengeId(UserChallengeId);
        progress.setChallengeSubId(1);
        progress.setStatus("OnProgress");
        progress.setStartedAt(Timestamp.valueOf(LocalDateTime.now()));
        progress.setDeadlineAt(Timestamp.valueOf(LocalDateTime.now().plusDays(1))); // Misalnya 2 hari durasi per sub-challenge
        challengeProgressRepository.save(progress);

        ChallengeJoinResponseDto userChallengeDto = userChallengeMapper.toChallengeJoinResponsetDto(saveUserChallenge);
        userChallengeDto.setJoinedat(DateFormatter.formatDateTime(dateNow));

        return userChallengeDto;
    }

    @Override
    public ChallengeSubCompletionResponse completeSubChallenge(ChallengeSubCompletionRequest request) {

        // menerima request
        String userChallengeId  = request.getUserChallengeId();
        Integer challengeSubId = request.getSubChallengeId();
        String proof            = request.getProofUrl();
        String caption          = request.getCaption();

        // validasi userChallengeProgress
        UserChallengeProgress userChallengeProgressData = challengeProgressRepository.findByUserChallengeIdAndChallengeSubId(userChallengeId,challengeSubId);
        if (userChallengeProgressData == null) throw new CustomExceptionHandler.ResourceNotFoundException("UserChallengeId", "Id = " + userChallengeId);

        // update data progress -> change status to complete.
        userChallengeProgressData.setStatus("Completed");
        userChallengeProgressData.setCaption(caption);
        userChallengeProgressData.setProofUrl(proof);
        userChallengeProgressData.setCompletedAt(Timestamp.valueOf(LocalDateTime.now()));
        userChallengeProgressData = challengeProgressRepository.save(userChallengeProgressData);

        return challengeProgressMapper.toChallengeSubCompletionResponse(userChallengeProgressData);
    }
}
