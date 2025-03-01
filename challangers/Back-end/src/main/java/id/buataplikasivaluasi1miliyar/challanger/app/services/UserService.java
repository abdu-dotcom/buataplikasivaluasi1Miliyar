package id.buataplikasivaluasi1miliyar.challanger.app.services;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.UserResponse;

import java.util.List;

public interface UserService {

    List<UserResponse> getUsers();

    String generateUserId();

    UserResponse createUser(String user_id, String username);
}
