package id.buataplikasivaluasi1miliyar.challanger.app.controllers;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.UserRequest;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.UserResponse;
import id.buataplikasivaluasi1miliyar.challanger.app.services.UserService;
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
@AllArgsConstructor
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UsersController {

    private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> getUsers() {
        logger.info("START  service : {} (API END POINT: {})", "getUsers", "/users");

        List<UserResponse> users = userService.getUsers();

        logger.info("END    service : {} (API END POINT: {})", "getUsers", "/users");
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/user/create")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request){
        logger.info("START  service : {} (API END POINT: {})", "createUser", "/user/create");

        // call service create user
        UserResponse user =userService.createUser(request);

        logger.info("END    service : {} (API END POINT: {})", "createUser", "/user/create");
        // return success
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    @GetMapping("/generateUserId")
    public String generateUserId(){
        return userService.generateUserId();
    }
}
