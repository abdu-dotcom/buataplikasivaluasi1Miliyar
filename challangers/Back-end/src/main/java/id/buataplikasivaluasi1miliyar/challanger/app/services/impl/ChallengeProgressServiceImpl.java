package id.buataplikasivaluasi1miliyar.challanger.app.services.impl;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow.ChallengeJoin.ChallengeJoinRequestDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow.ChallengeJoin.ChallengeJoinResponseDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow.ChallengeSubCompletion.ChallengeSubCompletionRequest;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow.ChallengeSubCompletion.ChallengeSubCompletionResponse;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow.ChallengeSubFailed.ChallengeSubFailedRequest;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow.ChallengeSubFailed.ChallengeSubFailedResponse;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.*;
import id.buataplikasivaluasi1miliyar.challanger.app.exception.CustomExceptionHandler;
import id.buataplikasivaluasi1miliyar.challanger.app.mapper.ChallengeProgressMapper;
import id.buataplikasivaluasi1miliyar.challanger.app.mapper.UserChallengeMapper;
import id.buataplikasivaluasi1miliyar.challanger.app.repository.*;
import id.buataplikasivaluasi1miliyar.challanger.app.services.ChallengeProgressService;
import id.buataplikasivaluasi1miliyar.challanger.app.services.ChallengeService;
import id.buataplikasivaluasi1miliyar.challanger.app.utils.DateFormatter;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ChallengeProgressServiceImpl implements ChallengeProgressService {

  private static final Logger logger = LoggerFactory.getLogger(ChallengeProgressServiceImpl.class);

  private final UsersRepository usersRepository;
  private final ChallengeProgressRepository challengeProgressRepository;
  private final ChallengeProgressMapper challengeProgressMapper;
  private final UserChallengeRepository userChallengeRepository;
  private final UserChallengeMapper userChallengeMapper;
  private final LeaderboardRepository leaderboardRepository;
  private final ChallengeRepository challengeRepository;

  private final ChallengeService challengeService;

  @Override
  public ChallengeJoinResponseDto acceptChallenge(ChallengeJoinRequestDto dto) {

    // validasi challenge id tidak ditemukan
    if (challengeRepository.findById(dto.getChallengeId()).isEmpty())
      throw new CustomExceptionHandler.ResourceNotFoundException("Challenge not found with Id: " + dto.getChallengeId());

    String isUserJoinedChallenge =
        userChallengeRepository.getUserChallengeByUserIdAndChallengeId(
            dto.getUserId(), dto.getChallengeId());
    String userId = dto.getUserId();

    // Cek apakah user sudah menerima challenge ini sebelumnya
    if (Objects.equals(isUserJoinedChallenge, "true"))
      throw new CustomExceptionHandler.DuplicateDataException(userId, dto.getChallengeId());

    int numberOfChallengeDay =
        userChallengeRepository.getNumberOfChallengeDaysByChallengeId(dto.getChallengeId());
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

    // start Challenge
    startSubChallenge(UserChallengeId, 1);

    ChallengeJoinResponseDto userChallengeDto =
        userChallengeMapper.toChallengeJoinResponsetDto(saveUserChallenge);
    userChallengeDto.setJoinedat(DateFormatter.formatDateTime(dateNow));

    return userChallengeDto;
  }

  @Override
  public ChallengeSubCompletionResponse completeSubChallenge(
      ChallengeSubCompletionRequest request) {

    // menerima request
    String userId = request.getUserId();
    String userChallengeId = request.getUserChallengeId();
    Integer challengeSubId = request.getSubChallengeId();
    String proof = request.getProofUrl();
    String caption = request.getCaption();

    // validasi userChallengeProgress
    UserChallengeProgress userChallengeProgressData =
        challengeProgressRepository.findByUserChallengeIdAndChallengeSubId(
            userChallengeId, challengeSubId);
    if (userChallengeProgressData == null)
      throw new CustomExceptionHandler.ResourceNotFoundException(
          "UserChallengeId", "Id = " + userChallengeId);

    // validasi challenge is already complated
    if (Objects.equals(userChallengeProgressData.getStatus(), "Completed"))
      throw new CustomExceptionHandler.BusinessException("Challenge sub is already completed");

    // update data progress -> change status to complete.
    userChallengeProgressData.setStatus("Completed");
    userChallengeProgressData.setCaption(caption);
    userChallengeProgressData.setProofUrl(proof);
    userChallengeProgressData.setCompletedAt(Timestamp.valueOf(LocalDateTime.now()));
    userChallengeProgressData = challengeProgressRepository.save(userChallengeProgressData);

    // Cek apakah user sudah ada di leaderboard
    Leaderboard userLeaderboardData =
        leaderboardRepository
            .findByUserId(userId)
            .orElseGet(
                () -> {
                  // Jika tidak ada, buat object baru
                  Leaderboard newLeaderboard = new Leaderboard();
                  newLeaderboard.setUserId(userId);
                  newLeaderboard.setScore(0); // Nilai awal
                  return newLeaderboard;
                });
    logger.info("userLeaderboardData: " + userLeaderboardData);

    // get challenge sub score
    Integer challengeId =
        userChallengeRepository.getChallengeIdByUserChallengeId(userChallengeId).getChallengeId();
    Integer scoreChallengeSub =
        challengeRepository.getScoreByIdAndChallengeSubId(
            challengeId, challengeSubId); // Misal 10 poin per sub-challenge

    // Update score (bisa sesuai logic kamu)
    userLeaderboardData.setScore(userLeaderboardData.getScore() + scoreChallengeSub);
    userLeaderboardData.setRecord_at(LocalDateTime.now());
    leaderboardRepository.save(userLeaderboardData);

    // validasi sub challenge selanjutnya
    Optional<Challenge> Challenge = challengeRepository.findById(challengeId);
    Integer subChallengeTotal = Challenge.get().getSubChallenges().size();

    if (challengeSubId != subChallengeTotal) {

      challengeSubId = challengeSubId + 1;
      String progresId = userChallengeId + challengeSubId;

      // create new next sub challenge
      UserChallengeProgress newProgressChallenge = new UserChallengeProgress();
      newProgressChallenge.setProgressId(progresId);
      newProgressChallenge.setUserChallengeId(userChallengeId);
      newProgressChallenge.setChallengeSubId(challengeSubId);
      newProgressChallenge.setStatus("OnProgress");
      newProgressChallenge.setStartedAt(Timestamp.valueOf(LocalDateTime.now()));
      newProgressChallenge.setDeadlineAt(
          Timestamp.valueOf(
              LocalDateTime.now().plusDays(1))); // Misalnya 2 hari durasi per sub-challenge
      challengeProgressRepository.save(newProgressChallenge);
    } else if (challengeSubId == subChallengeTotal) {
      // challenge complated
      UserChallenge saveUserChallenge =
          userChallengeRepository.getUserChallengeByUserChallengeId(userChallengeId);

      saveUserChallenge.setChallengeId(challengeId);
      saveUserChallenge.setStatus("Complated");
      saveUserChallenge.setFinishedat(LocalDateTime.now());
      userChallengeRepository.save(saveUserChallenge);
    }

    return challengeProgressMapper.toChallengeSubCompletionResponse(userChallengeProgressData);
  }

  @Override
  public ChallengeSubFailedResponse markSubChallengeAsFailed(ChallengeSubFailedRequest request) {
    logger.info("\n====== Method: markSubChallengeAsFailed == START ==");
    // menerima request
    String userId = request.getUserId();
    String userChallengeId = request.getUserChallengeId();
    Integer challengeSubId = request.getSubChallengeId();
    Timestamp dateNow = Timestamp.valueOf(LocalDateTime.now());

    // check user
    User user =
        usersRepository
            .findById(userId)
            .orElseThrow(
                () ->
                    new CustomExceptionHandler.ResourceNotFoundException(
                        String.format("UserId %s Not Found", userId)));

    // check data challenge
    UserChallengeProgress userChallengeProgress =
        challengeProgressRepository.findByUserChallengeIdAndChallengeSubId(
            userChallengeId, challengeSubId);

    // data tidak ditemukan
    if (userChallengeProgress == null)
      throw new CustomExceptionHandler.ResourceNotFoundException("Data not found");

    String status = userChallengeProgress.getStatus();
    Integer subChallengeId = userChallengeProgress.getChallengeSubId();

    // validasi challenge sub sudah failed
    if (status.equals("Failed"))
      throw new CustomExceptionHandler.BusinessException(
          "Sub-challenge ID " + subChallengeId + " has failed before");

    Timestamp deadlineAt = userChallengeProgress.getDeadlineAt();
    ChallengeSubFailedResponse challengeSubFailedResponse = new ChallengeSubFailedResponse();

    if (dateNow.after(deadlineAt)) {
      // ubah status menjadi failed
      userChallengeProgress.setStatus("Failed");
      userChallengeProgress.setCompletedAt(Timestamp.valueOf(LocalDateTime.now()));
      challengeProgressRepository.save(userChallengeProgress);

      // check next challenge sub
      Integer totalSubChallenge = challengeService.getChallengeSubById(challengeSubId).size();
      if (subChallengeId != totalSubChallenge){
        // start new challenge sub if exist
        startSubChallenge(userChallengeId, challengeSubId);
      }else{
        // set complated userProgress
        UserChallenge userChallenge = userChallengeRepository.getUserChallengeByUserChallengeId(userChallengeId);
        userChallenge.setStatus("Completed");
        userChallenge.setFinishedat(LocalDateTime.now());

        userChallengeRepository.save(userChallenge);
      }

      // give back response success
      challengeSubFailedResponse.setUserId(userId);
      challengeSubFailedResponse.setUserChallengeId(userChallengeId);
      challengeSubFailedResponse.setSubChallengeId(challengeSubId);
      challengeSubFailedResponse.setStatus("Failed");
      challengeSubFailedResponse.setComplatedAt(Timestamp.valueOf(LocalDateTime.now()));
    } else {
      challengeSubFailedResponse.setMessage("No challenges failed.");
    }
      logger.info("====== Method: markSubChallengeAsFailed == END ==");
      return challengeSubFailedResponse;
  }

  public Boolean startSubChallenge(String userChallengeId, Integer challengeSubId) {
    logger.info("\n====== Method: startSubChallenge == START ==");

    logger.info("====== VALUE VARIABLE ==");
    logger.info("====== PARAMS: userChallengeId = " + userChallengeId + " ===");
    logger.info("====== PARAMS: challengeSubId = " + challengeSubId + " ===");

    UserChallengeProgress userChallengeProgress =
        challengeProgressRepository.findByUserChallengeIdAndChallengeSubId(
            userChallengeId, challengeSubId);

    logger.info("====== VARIABLE: userChallengeProgress = " + userChallengeProgress + " ===");
    logger.info("====== VARIABLE: userChallengeId = " + userChallengeId + " ===");

    if (userChallengeProgress != null) challengeSubId = challengeSubId + 1;

    String progresId = userChallengeId + challengeSubId;

    // Insert ke user_challenge_progress untuk sub-challenge pertama
    UserChallengeProgress progress = new UserChallengeProgress();
    progress.setProgressId(progresId);
    progress.setUserChallengeId(userChallengeId);
    progress.setChallengeSubId(challengeSubId);
    progress.setStatus("OnProgress");
    progress.setStartedAt(Timestamp.valueOf(LocalDateTime.now()));
    progress.setDeadlineAt(
        Timestamp.valueOf(
            LocalDateTime.now().plusDays(1))); // Misalnya 2 hari durasi per sub-challenge
    challengeProgressRepository.save(progress);

    logger.info("====== Method: startSubChallenge == END == ======");
    return true;
  }
}
