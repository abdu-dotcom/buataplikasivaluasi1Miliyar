package id.buataplikasivaluasi1miliyar.challanger.app.services.impl;

import id.buataplikasivaluasi1miliyar.challanger.app.dto.UserRequest;
import id.buataplikasivaluasi1miliyar.challanger.app.dto.UserResponse;
import id.buataplikasivaluasi1miliyar.challanger.app.entity.User;
import id.buataplikasivaluasi1miliyar.challanger.app.mapper.UserMapper;
import id.buataplikasivaluasi1miliyar.challanger.app.repository.UsersRepository;
import id.buataplikasivaluasi1miliyar.challanger.app.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UsersRepository usersRepository;
    private final UserMapper userMapper;

    public List<UserResponse> getUsers(){

        List<UserResponse> users = usersRepository.findAll()
                .stream()
                .map(userMapper::toResponse) // Konversi dari User ke UserDto
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

    @Override
    public UserResponse createUser(String userId, String username) {

        logger.info("=== Before [userId] :" + "==>" + "["+ userId + "]");

        // check userId
        Boolean existsByUserId = usersRepository.existsByUserId(userId);
        // check username
        Boolean userExists = usersRepository.existsByUsername(username);

        if (existsByUserId) userId =  generateUserId(); // create userId baru
        if (userExists)  throw new IllegalArgumentException("Username sudah digunakan"); // error jika username exist

        // init data new user
        User user = new User();
        // set data user
        user.setUserId(userId);
        user.setUsername(username);
        user.setEmail("");
        user.setCreate_at(Timestamp.from(Instant.now()));
        user.setUpdate_at(Timestamp.from(Instant.now()));

        logger.info("=== [data user] :" + "==>" + "["+ user + "]");
        // create data user
        User userEntity = usersRepository.save(user);

        // return data
        return userMapper.toResponse(userEntity);
    }
}
