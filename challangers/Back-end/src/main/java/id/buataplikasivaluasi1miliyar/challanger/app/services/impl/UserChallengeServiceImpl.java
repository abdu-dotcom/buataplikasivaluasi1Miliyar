package id.buataplikasivaluasi1miliyar.challanger.app.services.impl;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.*;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.Challenge;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.UserChallenge;
import id.buataplikasivaluasi1miliyar.challanger.app.mapper.ChallengeMapper;
import id.buataplikasivaluasi1miliyar.challanger.app.mapper.UserChallengeMapper;
import id.buataplikasivaluasi1miliyar.challanger.app.repository.ChallengeRepository;
import id.buataplikasivaluasi1miliyar.challanger.app.repository.UserChallengeRepository;
import id.buataplikasivaluasi1miliyar.challanger.app.services.UserChallengeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserChallengeServiceImpl implements UserChallengeService {

    private final ChallengeRepository challengeRepository;
    private final ChallengeMapper challengeMapper;
    private final UserChallengeRepository repository;
    private final UserChallengeMapper mapper;

    @Override
    public UserChallengeDto acceptChallenge(UserChallengeDto dto) {

        System.out.println(dto.getUserChallengeId());
        System.out.println(dto.getStatus());
        System.out.println(dto.getJoinedat());
        System.out.println(dto.getUserId());
       // init data new user
        UserChallenge userChallenge = mapper.toEntity(dto);

        UserChallenge saveUserChallenge = repository.save(userChallenge);
        repository.flush();
        return mapper.toDTO(saveUserChallenge);
    }

    @Override
    public List<UserChallengeDto> getAllChallengesByUser(String userId) {
        return repository.findAll().stream()
                .filter(challenge -> challenge.getUserId().equals(userId))
                .map(mapper::toDTO)
                .collect(Collectors.toList());
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
            // Ambil progress detail (bisa null)
            UserChallengeProgressDto progressDetail = null;
            if (row[6] != null) {
                progressDetail = new UserChallengeProgressDto();
                progressDetail.setStatus((String) row[7]);
                progressDetail.setCompletedAt(row[8] != null ? ((Timestamp) row[8]).toLocalDateTime() : null);
            } else{
                progressDetail = new UserChallengeProgressDto();
                progressDetail.setStatus("null");
                progressDetail.setCompletedAt(null);
            }
            subChallenge.setChallengeSubProgress(progressDetail);

            subChallenges.add(subChallenge);
        }

        challengeDetailDto.setSubChallenges(subChallenges);
        userChallengeDetailDto.setChallengeDetail(challengeDetailDto);

        return userChallengeDetailDto;
    }
}
