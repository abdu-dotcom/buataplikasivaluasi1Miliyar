package id.buataplikasivaluasi1miliyar.challanger.app.services.impl;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.UserDto;
import id.buataplikasivaluasi1miliyar.challanger.app.mapper.UserMapper;
import id.buataplikasivaluasi1miliyar.challanger.app.repository.UsersRepository;
import id.buataplikasivaluasi1miliyar.challanger.app.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UsersRepository usersRepository;
    private final UserMapper userMapper;

    public List<UserDto> getUsers(){

        List<UserDto> users = usersRepository.findAll()
                .stream()
                .map(userMapper::mapToUserDto) // Konversi dari User ke UserDto
                .collect(Collectors.toList());

        return users;
    }
}
