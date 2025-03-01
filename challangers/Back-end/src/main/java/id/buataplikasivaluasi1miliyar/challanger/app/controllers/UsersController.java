package id.buataplikasivaluasi1miliyar.challanger.app.controllers;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.UserRequest;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.UserResponse;
import id.buataplikasivaluasi1miliyar.challanger.app.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class UsersController {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> getUsers() {

        List<UserResponse> users = userService.getUsers();

        System.out.println("Mapping user: " + users.size()); // Debug mapping
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/user/create")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request){

        // get value request
        String user_id = request.getUser_id();
        String username = request.getUsername();

        // call service create user
        UserResponse user =userService.createUser(user_id, username);

        // return success
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    @GetMapping("/generateUserId")
    public String generateUserId(){
        return userService.generateUserId();
    }
}
