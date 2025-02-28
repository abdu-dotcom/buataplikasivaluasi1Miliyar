package id.buataplikasivaluasi1miliyar.challanger.app.services.impl;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.UserDto;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.User;
import id.buataplikasivaluasi1miliyar.challanger.app.mapper.UserMapper;
import id.buataplikasivaluasi1miliyar.challanger.app.repository.UsersRepository;
import id.buataplikasivaluasi1miliyar.challanger.app.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

  public String generateUserId() {
        // create userId berdasarkan username + sequence. Ex: CHALLENGE000001
        String userId = null;

        // get higher userId
        Optional<String> lastUserIdOpt =  usersRepository.findLastUserId();

        // Check jika challenger baru
        if (lastUserIdOpt.isEmpty()){
            userId = "CHALLENGE000001";
        }

        String lastUserId = lastUserIdOpt.get(); // Misal: "CHALLENGE00100"
        System.out.println("lastUserId: " + lastUserId);
        int lastNumber = Integer.parseInt(lastUserId.substring(9));

        // Tambah 1, lalu format ke CHALLENGE0000001
        return String.format("CHALLENGE%06d", lastNumber + 1);
    }
}
