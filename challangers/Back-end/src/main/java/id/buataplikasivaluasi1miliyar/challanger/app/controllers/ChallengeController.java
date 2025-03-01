package id.buataplikasivaluasi1miliyar.challanger.app.controllers;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.CategoryDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeDto;
import id.buataplikasivaluasi1miliyar.challanger.app.services.CategoryService;
import id.buataplikasivaluasi1miliyar.challanger.app.services.ChallengeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class ChallengeController {

    private final ChallengeService challengeService;

    @GetMapping("/challengers")
    public ResponseEntity<List<ChallengeDto>> getChallengers() {

        List<ChallengeDto> challengers = challengeService.getChallengers();

        System.out.println("Mapping categories: " + challengers.size()); // Debug mapping
        return new ResponseEntity<>(challengers, HttpStatus.OK);
    }
}
