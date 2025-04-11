package id.buataplikasivaluasi1miliyar.challanger.app.controllers;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.Leaderboard.LeaderboardDto;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.Leaderboard;
import id.buataplikasivaluasi1miliyar.challanger.app.services.LeaderboardService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class LeaderboardController {

    private static final Logger logger = LoggerFactory.getLogger(LeaderboardController.class);
    private final LeaderboardService leaderboardService;

    @GetMapping("/leaderboard/{userId}")
    public ResponseEntity<LeaderboardDto> getLeaderboard(@PathVariable("userId") String userId) {
        logger.info("START  service : {} (API END POINT: {})", "getLeaderboard", "/leaderboard/{userId}");

        LeaderboardDto leaderboard = leaderboardService.getLeaderboard(userId);

        logger.info("END    service : {} (API END POINT: {})", "getLeaderboard", "/leaderboard/{userId}");
        return new ResponseEntity<>(leaderboard, HttpStatus.OK);
    }
}
