package id.buataplikasivaluasi1miliyar.challanger.app.controllers;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeDetailDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeDto;
import id.buataplikasivaluasi1miliyar.challanger.app.services.ChallengeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class  ChallengeController {

    private final ChallengeService challengeService;

    @GetMapping("/challengers")
    public ResponseEntity<List<ChallengeDto>> getChallengers() {
        List<ChallengeDto> challengers = challengeService.getChallengers();
        return new ResponseEntity<>(challengers, HttpStatus.OK);
    }
    @GetMapping("/challenger/category/{categoryId}")
    public  ResponseEntity<List<ChallengeDto>> getChallengerByCategoryId(@PathVariable("categoryId") Integer categoryId) {
        System.out.println("Id: " + categoryId);
        List<ChallengeDto> challengeWithSub =  challengeService.getChallengeByCategoryId(categoryId);
        return new ResponseEntity<>(challengeWithSub, HttpStatus.OK);
    }
    @GetMapping("/challenger/{challenge_id}")
    public  ResponseEntity<ChallengeDetailDto> getChallengerById(@PathVariable("challenge_id") Integer challenge_id) {
        ChallengeDetailDto challengeWithSub =  challengeService.getChallengeById(challenge_id);
        return new ResponseEntity<>(challengeWithSub, HttpStatus.OK);
    }
}
