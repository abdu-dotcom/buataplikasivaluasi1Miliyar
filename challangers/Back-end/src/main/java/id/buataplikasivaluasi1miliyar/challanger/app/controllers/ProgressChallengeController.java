package id.buataplikasivaluasi1miliyar.challanger.app.controllers;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow.ProcessChallengeDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.UserChallengeDto;
import id.buataplikasivaluasi1miliyar.challanger.app.services.ProcessChallengeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class ProgressChallengeController {

    private ProcessChallengeService processChallengeService;

    @PostMapping("/start-challenge")
    public ResponseEntity<ProcessChallengeDto> startChallenge(@RequestBody ProcessChallengeDto request) {
        ProcessChallengeDto result = processChallengeService.startChallenge(request);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/complate-challenge/{progressId}")
    public ResponseEntity<ProcessChallengeDto> complateChallenge(@PathVariable Integer progressId, @RequestBody ProcessChallengeDto request) {
        ProcessChallengeDto result = processChallengeService.complateUserChallengeProgress(progressId, request);
        return ResponseEntity.ok(result);
    }
}
