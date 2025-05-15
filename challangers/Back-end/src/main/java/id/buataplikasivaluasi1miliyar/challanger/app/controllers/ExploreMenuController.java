package id.buataplikasivaluasi1miliyar.challanger.app.controllers;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ExploreMenu.ExploreMenuDto;
import id.buataplikasivaluasi1miliyar.challanger.app.services.ExploreMenuService;
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
public class ExploreMenuController {

    private static final Logger logger = LoggerFactory.getLogger(ExploreMenuController.class);
    private final ExploreMenuService exploreMenuService;

    @GetMapping("/explore-menu/other-users")
    public ResponseEntity<List<ExploreMenuDto>> getProgresAllUsers() {
        logger.info("START  service : {} (API END POINT: {})", "getProgresAllUsers", "/explore-menu/other-users");

        List<ExploreMenuDto> exploreProgressUsers = exploreMenuService.getProgresAllUsers();

        logger.info("END    service : {} (API END POINT: {})", "getProgresAllUsers", "/explore-menu/other-users");
        return new ResponseEntity<>(exploreProgressUsers, HttpStatus.OK);
    }

    @GetMapping("/explore-menu/user/{userId}")
    public ResponseEntity<List<ExploreMenuDto>> getProgresAUser(@PathVariable String userId) {
        logger.info("START  service : {} (API END POINT: {})", "getProgresAUser", "/explore-menu/user/{userId}");

        List<ExploreMenuDto> exploreProgressUsers = exploreMenuService.getProgressAUser(userId);

        logger.info("END    service : {} (API END POINT: {})", "getProgresAllUsers", "/explore-menu/other-users");
        return new ResponseEntity<>(exploreProgressUsers, HttpStatus.OK);
    }
}
