package id.buataplikasivaluasi1miliyar.challanger.app.services;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.UserDto;
import java.util.List;

public interface UserService {
    List<UserDto> getUsers();

    String generateUserId();
}
