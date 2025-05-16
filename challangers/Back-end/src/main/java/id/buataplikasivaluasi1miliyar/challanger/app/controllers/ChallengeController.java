package id.buataplikasivaluasi1miliyar.challanger.app.controllers;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeDetailDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeDto;
import id.buataplikasivaluasi1miliyar.challanger.app.services.ChallengeService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class  ChallengeController {

    private static final Logger logger = LoggerFactory.getLogger(ChallengeController.class);

    @Autowired
    private final ChallengeService challengeService;

    @GetMapping("/challengers")
    public ResponseEntity<List<ChallengeDto>> getChallengers() {
        logger.info("START  service : {} (API END POINT: {})", "getChallengers", "/challengers");

        List<ChallengeDto> challengers = challengeService.getChallengers();

        logger.info("END    service : {} (API END POINT: {})", "getChallengers", "/challengers");
        return new ResponseEntity<>(challengers, HttpStatus.OK);
    }
    @GetMapping("/challenger/category/{categoryId}")
    public  ResponseEntity<List<ChallengeDto>> getChallengerByCategoryId(@PathVariable("categoryId") Integer categoryId) {
        logger.info("START  service : {} (API END POINT: {})", "getChallengerByCategoryId", "/challenger/category/{categoryId}");

        List<ChallengeDto> challengeWithSub =  challengeService.getChallengeByCategoryId(categoryId);

        logger.info("END    service : {} (API END POINT: {})", "getChallengerByCategoryId", "/challenger/category/{categoryId}");
        return new ResponseEntity<>(challengeWithSub, HttpStatus.OK);
    }
    @GetMapping("/challenger/{challenge_id}")
    public  ResponseEntity<ChallengeDetailDto> getChallengerById(@PathVariable("challenge_id") Integer challenge_id) {
        logger.info("START  service : {} (API END POINT: {})", "getChallengerById", "/challenger/{challenge_id}");

        ChallengeDetailDto challengeWithSub =  challengeService.getChallengeById(challenge_id);

        logger.info("END  service : {} (API END POINT: {})", "getChallengerById", "/challenger/{challenge_id}");
        return new ResponseEntity<>(challengeWithSub, HttpStatus.OK);
    }
}
