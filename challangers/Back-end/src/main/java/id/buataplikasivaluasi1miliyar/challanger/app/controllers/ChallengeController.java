package id.buataplikasivaluasi1miliyar.challanger.app.controllers;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.CategoryDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeDetailDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeSubDto;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.Challenge;
import id.buataplikasivaluasi1miliyar.challanger.app.services.CategoryService;
import id.buataplikasivaluasi1miliyar.challanger.app.services.ChallengeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/challenger/category/{categoryId}")
    public  ResponseEntity<List<ChallengeDetailDto>> getChallengerByCategoryId(@PathVariable("categoryId") Integer categoryId) {
        System.out.println("Id: " + categoryId);
        List<ChallengeDetailDto> challengeWithSub =  challengeService.getChallengeByCategoryId(categoryId);
        return new ResponseEntity<>(challengeWithSub, HttpStatus.OK);
    }
    @GetMapping("/challenger/{id}")
    public  ResponseEntity<ChallengeDetailDto> getChallengerById(@PathVariable("challenge_id") Integer challenge_id) {
    System.out.println("challenge_id: " + challenge_id);
        ChallengeDetailDto challengeWithSub =  challengeService.getChallengeById(challenge_id);
        return new ResponseEntity<>(challengeWithSub, HttpStatus.OK);
    }


}
