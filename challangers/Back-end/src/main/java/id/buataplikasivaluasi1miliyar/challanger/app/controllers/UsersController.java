package id.buataplikasivaluasi1miliyar.challanger.app.controllers;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.UserDto;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.User;
import id.buataplikasivaluasi1miliyar.challanger.app.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class UsersController {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUsers() {

        List<UserDto> users = userService.getUsers();

        System.out.println("Mapping user: " + users.size()); // Debug mapping
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/generateUserId")
    public String generateUserId(){
        return userService.generateUserId();
    }
}
