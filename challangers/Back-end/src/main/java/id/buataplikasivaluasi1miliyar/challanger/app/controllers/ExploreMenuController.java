package id.buataplikasivaluasi1miliyar.challanger.app.controllers;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.ChallengeDto;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.ExploreMenu.ExploreMenuDto;
import id.buataplikasivaluasi1miliyar.challanger.app.services.ExploreMenuService;
import lombok.AllArgsConstructor;
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

    private final ExploreMenuService exploreMenuService;

    @GetMapping("/explore-menu/other-users")
    public ResponseEntity<List<ExploreMenuDto>> getProgresAllUsers() {
        List<ExploreMenuDto> exploreProgressUsers = exploreMenuService.getProgresAllUsers();
        return new ResponseEntity<>(exploreProgressUsers, HttpStatus.OK);
    }

    @GetMapping("/explore-menu/user/{userId}")
    public ResponseEntity<List<ExploreMenuDto>> getProgresAllUsers(@PathVariable String userId) {
        List<ExploreMenuDto> exploreProgressUsers = exploreMenuService.getProgressAUser(userId);
        return new ResponseEntity<>(exploreProgressUsers, HttpStatus.OK);
    }
}
