package id.buataplikasivaluasi1miliyar.challanger.app.mapper;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.UserRequest;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.UserResponse;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    // Convert UserRequest DTO ke User Entity
    public UserRequest toEntity(UserRequest userRequest) {
    return new UserRequest(
        userRequest.getUser_id(), // ID (jika perlu, atau bisa di-set null)
        userRequest.getUsername());
    };

    // Convert UserDto into JPA Entity | Response
    public UserResponse toResponse(User user){

    return new UserResponse(
        user.getUserId(),
        user.getUsername(),
        user.getEmail(),
        user.getCreate_at(),
        user.getUpdate_at());
    }

}
