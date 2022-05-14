package ru.kpfu.itis.services;

import ru.kpfu.itis.dto.LoginDto;
import ru.kpfu.itis.dto.UserDto;
import ru.kpfu.itis.form.LoginForm;
import ru.kpfu.itis.models.Match;
import ru.kpfu.itis.models.User;

import javax.servlet.http.Cookie;
import java.util.List;


public interface UsersService {
    User addUser(UserDto userDto);


//    void requestMessage(RequestForm requestForm);
}
