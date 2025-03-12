package id.buataplikasivaluasi1miliyar.challanger.app.services.impl;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeDetailDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeDto;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.Challenge;
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


    // mendapatkan seluruh data challenger tanpa sub challenge
    @Override
    public List<ChallengeDto> getChallengers() {
        List<ChallengeDto> users = challengeRepository.findAll()
                .stream()
                .map(challengeMapper::toChallengeDto) // Konversi dari User ke UserDto
                .collect(Collectors.toList());

        return users;
    }

    // ✅ Ambil Challenge + Sub-Challenges by Id challenge(GET)
    public ChallengeDetailDto getChallengeById(Integer challengeId) {
        Challenge challenge = challengeRepository.getChallengeById(challengeId)
                .orElseThrow(() -> new RuntimeException("Challenge tidak ditemukan"));
        return challengeMapper.toChallengeDetailDto(challenge);
    }

    // ✅ Ambil Challenge + Sub-Challenges by Category Id(GET)
    public List<ChallengeDto> getChallengeByCategoryId(Integer categoryId) {
        List<ChallengeDto> challenge = challengeRepository.findByCategoryId(categoryId)
                .stream()
                .map(challengeMapper::toChallengeDto) // Konversi dari User ke UserDto
                .collect(Collectors.toList());

        return challenge;
    }
}
