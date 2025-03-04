package id.buataplikasivaluasi1miliyar.challanger.app.controllers;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeProcessFlow.StartChallengeDto;
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
    public ResponseEntity<StartChallengeDto> startChallenge(@RequestBody StartChallengeDto request) {
        StartChallengeDto result = processChallengeService.startChallenge(request);
        return ResponseEntity.ok(result);
    }

}
