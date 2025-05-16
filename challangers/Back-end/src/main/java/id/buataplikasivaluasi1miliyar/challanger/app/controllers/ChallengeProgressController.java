package id.buataplikasivaluasi1miliyar.challanger.app.controllers;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow.ChallengeJoin.ChallengeJoinRequestDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow.ChallengeJoin.ChallengeJoinResponseDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow.ChallengeSubCompletion.ChallengeSubCompletionRequest;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow.ChallengeSubCompletion.ChallengeSubCompletionResponse;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow.ChallengeSubFailed.ChallengeSubFailedRequest;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow.ChallengeSubFailed.ChallengeSubFailedResponse;
import id.buataplikasivaluasi1miliyar.challanger.app.services.ChallengeProgressService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ChallengeProgressController {

    private static final Logger logger = LoggerFactory.getLogger(ChallengeProgressController.class);

    @Autowired
    private ChallengeProgressService challengeProgressService;

    /** Process user klik accept challenge artinya user mengikutin challenge dan mulai progress */
    @PostMapping("/accept-challenge")
    public ResponseEntity<ChallengeJoinResponseDto
            > acceptChallenge(@RequestBody ChallengeJoinRequestDto dto) {
        logger.info("START  service : {} (API END POINT: {})", "acceptChallenge", "/accept-challenge");

        ChallengeJoinResponseDto result = challengeProgressService.acceptChallenge(dto);

        logger.info("END    service : {} (API END POINT: {})", "acceptChallenge", "/accept-challenge");
        return ResponseEntity.ok(result);
    }

    /** Process user upload bukti challenge */
    @PostMapping("/challenges/sub-challenges/complete")
    public ResponseEntity<ChallengeSubCompletionResponse> completeSubChallenge(@RequestBody ChallengeSubCompletionRequest request) {
        logger.info("START  service : {} (API END POINT: {})", "completeSubChallenge", "/challenges/sub-challenges/complete");

        ChallengeSubCompletionResponse challengeSubCompletionResponse = challengeProgressService.completeSubChallenge(request);

        logger.info("END    service : {} (API END POINT: {})", "completeSubChallenge", "/challenges/sub-challenges/complete");
        return ResponseEntity.ok(challengeSubCompletionResponse);
    }

    /** Proses user challenge sub lewat deadline dan akan ubah status */
    @PostMapping("challenges/fail-sub-challenge")
    public  ResponseEntity<ChallengeSubFailedResponse> challengeSubFailure(@RequestBody ChallengeSubFailedRequest request){
        ChallengeSubFailedResponse challengeSubFailedResponse = challengeProgressService.markSubChallengeAsFailed(request);
        return ResponseEntity.ok(challengeSubFailedResponse);
    }
}
