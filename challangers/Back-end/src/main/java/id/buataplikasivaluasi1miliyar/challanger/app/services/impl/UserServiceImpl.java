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

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UsersRepository usersRepository;
    private final UserMapper userMapper;

    /** Mendapatkan user semua data user */
    public List<UserResponse> getUsers(){
        return usersRepository.findAll()
                .stream()
                .map(userMapper::toResponse) // Konversi dari User ke UserDto
                .collect(Collectors.toList());
    }

    /** Membuat userId berdasarkan username + sequence. Ex: CHALLENGE000001 */
  public String generateUserId() {

      String userId = "CHALLENGE000001";

      // get higher userId
      Optional<String> lastUserIdOpt =  usersRepository.findLastUserId();

      // Check jika challenger lama
      if (lastUserIdOpt.isPresent()) userId = lastUserIdOpt.get();

      // get sequence number from userId. Ex: 000001
      int sequenceUserId = Integer.parseInt(userId.substring(9));

      // Tambah 1, lalu format ke CHALLENGE0000001
      return String.format("CHALLENGE%06d", sequenceUserId + 1);
    }

    /** Membuat data user baru */
    @Override
    public UserResponse createUser(UserRequest request) {

        String userId = request.getUser_id();
        String username = request.getUsername();

        // check userId
        Boolean existsByUserId = usersRepository.existsByUserId(userId);

        // check username
        Boolean userExists = usersRepository.existsByUsername(username);

        if (userExists)  throw new IllegalArgumentException("Username sudah digunakan"); // error jika username exist
        if (existsByUserId) userId =  generateUserId(); // create userId baru

        // init data new user
        User user = User.builder()
                .userId(userId)
                .username(username)
                .email("") // default kosong
                .create_at(Timestamp.from(Instant.now()))
                .update_at(Timestamp.from(Instant.now()))
                .build();

        // save user
        User userEntity = usersRepository.save(user);

        // return response
        return userMapper.toResponse(userEntity);
    }
}
