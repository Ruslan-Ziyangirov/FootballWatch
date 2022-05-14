package ru.kpfu.itis.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.dto.LoginDto;
import ru.kpfu.itis.dto.UserDto;
import ru.kpfu.itis.models.Authorization;
import ru.kpfu.itis.models.Match;
import ru.kpfu.itis.models.User;
import ru.kpfu.itis.repositories.AuthRepository;
import ru.kpfu.itis.repositories.MatchRepository;
import ru.kpfu.itis.repositories.UserRepository;
import javax.servlet.http.Cookie;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class UsersServicesImpl implements UsersService {

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MatchRepository matchRepository;


    @Override
    public User addUser(UserDto userDto) {
        String passwordHash = new BCrypt().hashpw(userDto.getPassword(),BCrypt.gensalt(4));
        User user = User.builder()
                        .first_name(userDto.getFirst_name())
                                .second_name(userDto.getSecond_name())
                                        .login(userDto.getLogin())
                                                .passwordHash(passwordHash)
                                                        .email(userDto.getEmail())
                                                                .build();
        userRepository.save(user);
        return user;
    }


}
