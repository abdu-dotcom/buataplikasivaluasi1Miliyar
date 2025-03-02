package id.buataplikasivaluasi1miliyar.challanger.app.services.impl;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.UserChallengeDto;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.User;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.UserChallenge;
import id.buataplikasivaluasi1miliyar.challanger.app.mapper.UserChallengeMapper;
import id.buataplikasivaluasi1miliyar.challanger.app.repository.UserChallengeRepository;
import id.buataplikasivaluasi1miliyar.challanger.app.services.UserChallengeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserChallengeServiceImpl implements UserChallengeService {

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
}
