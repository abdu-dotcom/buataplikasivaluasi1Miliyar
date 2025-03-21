package id.buataplikasivaluasi1miliyar.challanger.app.controllers;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow.ChallengeJoin.ChallengeJoinRequestDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow.ChallengeJoin.ChallengeJoinResponseDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow.ChallengeSubCompletion.ChallengeSubCompletionRequest;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow.ChallengeSubCompletion.ChallengeSubCompletionResponse;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow.ChallengeSubFailed.ChallengeSubFailedRequest;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow.ChallengeSubFailed.ChallengeSubFailedResponse;
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

    /** Proses user challenge sub lewat deadline dan akan ubah status */
    @PostMapping("challenges/fail-sub-challenge")
    public  ResponseEntity<ChallengeSubFailedResponse> challengeSubFailure(@RequestBody ChallengeSubFailedRequest request){
        ChallengeSubFailedResponse challengeSubFailedResponse = challengeProgressService.markSubChallengeAsFailed(request);
        return ResponseEntity.ok(challengeSubFailedResponse);
    }
}
