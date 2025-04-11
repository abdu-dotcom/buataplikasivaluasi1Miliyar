package id.buataplikasivaluasi1miliyar.challanger.app.controllers;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.ExploreMenu.ExploreMenuDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.Leaderboard.LeaderboardDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.Motivation.MotivationDto;
import id.buataplikasivaluasi1miliyar.challanger.app.services.MotivationService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class MotivationController {

    private static final Logger logger = LoggerFactory.getLogger(MotivationController.class);
    private MotivationService motivationService;

    @GetMapping("/motivations")
    public ResponseEntity<List<MotivationDto>> getMotivationList() {
        logger.info("START  service : {} (API END POINT: {})", "getMotivationList", "/motivations");

        List<MotivationDto> motivationDto = motivationService.getAllMotivation();

        logger.info("END    service : {} (API END POINT: {})", "getMotivationList", "/motivations");
        return new ResponseEntity<>(motivationDto, HttpStatus.OK);
    }
}
