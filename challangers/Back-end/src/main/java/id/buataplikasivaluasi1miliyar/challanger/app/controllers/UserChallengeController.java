package id.buataplikasivaluasi1miliyar.challanger.app.controllers;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.UserChallengeDetailDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.UserChallengeListResponseDTO;
import id.buataplikasivaluasi1miliyar.challanger.app.services.UserChallengeService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user-challenge")
public class UserChallengeController {

    private static final Logger logger = LoggerFactory.getLogger(UserChallengeController.class);

    @Autowired
    private final UserChallengeService service;

    @GetMapping("/{userId}")
    public ResponseEntity<UserChallengeListResponseDTO> getUserChallenges(@PathVariable String userId) {
        logger.info("START  service : {} (API END POINT: {})", "getUserChallenges", "/{userId}");

        UserChallengeListResponseDTO challenges = service.getAllChallengesByUser(userId);

        logger.info("END    service : {} (API END POINT: {})", "getUserChallenges", "/{userId}");
        return ResponseEntity.ok(challenges);
    }

    @GetMapping("/{userId}/challenge/{challengeId}")
    public ResponseEntity<UserChallengeDetailDto> getUserChallengesDetail(@PathVariable String userId, @PathVariable Integer challengeId) {
        logger.info("START  service : {} (API END POINT: {})", "getUserChallengesDetail", "/{userId}/challenge/{challengeId}");

        UserChallengeDetailDto challenges = service.getUserChallengeDetail(userId, challengeId);

        logger.info("END    service : {} (API END POINT: {})", "getUserChallengesDetail", "/{userId}/challenge/{challengeId}");
        return ResponseEntity.ok(challenges);
    }
}
