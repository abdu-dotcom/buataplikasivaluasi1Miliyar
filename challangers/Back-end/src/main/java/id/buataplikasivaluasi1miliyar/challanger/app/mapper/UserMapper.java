package id.buataplikasivaluasi1miliyar.challanger.app.mapper;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.UserDto;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    // Convert User JPA Entity into UserDto
    public UserDto mapToUserDto(User user){
           return new UserDto(
                user.getUser_id(),
                user.getUsername(),
                user.getEmail(),
                user.getCreate_at(),
                user.getUpdate_at()
        );
    };

    // Convert UserDto into JPA Entity
    public User mapToUser(UserDto userDto){

        return new User(
                userDto.getUser_id(),
                userDto.getUsername(),
                userDto.getEmail(),
                userDto.getCreate_at(),
                userDto.getUpdate_at()
        );
    }
}
