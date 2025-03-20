package id.buataplikasivaluasi1miliyar.challanger.app.controllers;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeJoin.ChallengeJoinRequestDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeJoin.ChallengeJoinResponseDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeSubCompletion.ChallengeSubCompletionRequest;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeSubCompletion.ChallengeSubCompletionResponse;
import id.buataplikasivaluasi1miliyar.challanger.app.services.ChallengeProgressService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class ChallengeProgressController {

    private ChallengeProgressService challengeProgressService;

    /** Process user klik accept challenge artinya user mengikutin challenge dan mulai progress */
    @PostMapping("/accept-challenge")
    public ResponseEntity<ChallengeJoinResponseDto
            > acceptChallenge(@RequestBody ChallengeJoinRequestDto dto) {
        ChallengeJoinResponseDto result = challengeProgressService.acceptChallenge(dto);
        return ResponseEntity.ok(result);
    }

    /** Process user upload bukti challenge */
    @PostMapping("/challenges/sub-challenges/complete")
    public ResponseEntity<ChallengeSubCompletionResponse> completeSubChallenge(@RequestBody ChallengeSubCompletionRequest request) {
        ChallengeSubCompletionResponse challengeSubCompletionResponse = challengeProgressService.completeSubChallenge(request);
        return ResponseEntity.ok(challengeSubCompletionResponse);
    }
}
