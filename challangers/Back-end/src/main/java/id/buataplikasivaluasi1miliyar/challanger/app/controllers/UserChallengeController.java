package id.buataplikasivaluasi1miliyar.challanger.app.controllers;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.UserChallengeDto;
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

    @PostMapping("/accept-challenge")
    public ResponseEntity<UserChallengeDto> acceptChallenge(@RequestBody UserChallengeDto dto) {
        UserChallengeDto result = service.acceptChallenge(dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<UserChallengeDto>> getUserChallenges(@PathVariable String userId) {
        List<UserChallengeDto> challenges = service.getAllChallengesByUser(userId);
        return ResponseEntity.ok(challenges);
    }
}
