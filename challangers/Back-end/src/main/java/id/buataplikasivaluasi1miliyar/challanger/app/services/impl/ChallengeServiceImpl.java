package id.buataplikasivaluasi1miliyar.challanger.app.services.impl;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeDetailDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeDto;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.Challenge;
import id.buataplikasivaluasi1miliyar.challanger.app.exception.CustomExceptionHandler;
import id.buataplikasivaluasi1miliyar.challanger.app.mapper.ChallengeMapper;
import id.buataplikasivaluasi1miliyar.challanger.app.repository.ChallengeRepository;
import id.buataplikasivaluasi1miliyar.challanger.app.services.ChallengeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ChallengeServiceImpl implements ChallengeService {

    private final ChallengeRepository challengeRepository;
    private final ChallengeMapper challengeMapper;

    // ✅ mendapatkan seluruh data challenger tanpa sub challenge
    @Override
    public List<ChallengeDto> getChallengers() {
        List<Challenge> challenges = challengeRepository.findAll();

        if (challenges.isEmpty()) throw new CustomExceptionHandler.ResourceNotFoundException("Challenge tidak ditemukan");

        return challenges.stream()
                .map(challengeMapper::toChallengeDto) // Konversi dari User ke UserDto
                .collect(Collectors.toList());
    }

    // ✅ Ambil Challenge + Sub-Challenges by Id challenge(GET)
    public ChallengeDetailDto getChallengeById(Integer challengeId) {
    Challenge challenge =
        challengeRepository
            .getChallengeById(challengeId)
            .orElseThrow(
                    () -> new CustomExceptionHandler.ResourceNotFoundException(
                        "Challenge ", "ChallengeId = " + challengeId));
        return challengeMapper.toChallengeDetailDto(challenge);
    }

    // ✅ Ambil Challenge + Sub-Challenges by Category Id(GET)
    public List<ChallengeDto> getChallengeByCategoryId(Integer categoryId) {
        List<Challenge> challenges =  challengeRepository.findByCategoryId(categoryId);

        if (challenges.isEmpty()) throw new CustomExceptionHandler.ResourceNotFoundException("Challenge", "Category = " + categoryId );

        return challenges
                .stream()
                .map(challengeMapper::toChallengeDto) // Konversi dari User ke UserDto
                .collect(Collectors.toList());
    }
}
