package id.buataplikasivaluasi1miliyar.challanger.app.services.impl;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeDto;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.Challenge;
import id.buataplikasivaluasi1miliyar.challanger.app.mapper.ChallengeMapper;
import id.buataplikasivaluasi1miliyar.challanger.app.repository.ChallengeRepository;
import id.buataplikasivaluasi1miliyar.challanger.app.services.ChallengeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ChallengeServiceImpl implements ChallengeService {

    private final ChallengeRepository challengeRepository;
    private final ChallengeMapper challengeMapper;


    @Override
    public List<ChallengeDto> getChallengers() {
        List<ChallengeDto> users = challengeRepository.findAll()
                .stream()
                .map(challengeMapper::toDto) // Konversi dari User ke UserDto
                .collect(Collectors.toList());

        return users;
    }

    // ✅ Ambil Challenge + Sub-Challenges (GET)
    public ChallengeDto getChallengeById(Integer challengeId) {
        Challenge challenge = challengeRepository.findById(challengeId)
                .orElseThrow(() -> new RuntimeException("Challenge tidak ditemukan"));
        return challengeMapper.toDto(challenge);
    }
}
