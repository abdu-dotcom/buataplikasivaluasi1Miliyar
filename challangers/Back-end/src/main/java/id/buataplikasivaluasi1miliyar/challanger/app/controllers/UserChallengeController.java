package id.buataplikasivaluasi1miliyar.challanger.app.controllers;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeJoin.ChallengeJoinRequestDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeJoin.ChallengeJoinResponseDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.UserChallengeDetailDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.UserChallengeListResponseDTO;
import id.buataplikasivaluasi1miliyar.challanger.app.services.UserChallengeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user-challenge")
@RequiredArgsConstructor
public class UserChallengeController {

    private final UserChallengeService service;

    @GetMapping("/{userId}")
    public ResponseEntity<UserChallengeListResponseDTO> getUserChallenges(@PathVariable String userId) {
        UserChallengeListResponseDTO challenges = service.getAllChallengesByUser(userId);
        return ResponseEntity.ok(challenges);
    }

    @GetMapping("/{userId}/challenge/{challengeId}")
    public ResponseEntity<UserChallengeDetailDto> getUserChallenges(@PathVariable String userId, @PathVariable Integer challengeId) {
        UserChallengeDetailDto challenges = service.getUserChallengeDetail(userId, challengeId);
        return ResponseEntity.ok(challenges);
    }
}
