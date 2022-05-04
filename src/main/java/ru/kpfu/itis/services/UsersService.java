package ru.kpfu.itis.services;

import ru.kpfu.itis.dto.UserDto;
import ru.kpfu.itis.form.LoginForm;

import javax.servlet.http.Cookie;


public interface UsersService {
    void addUser(UserDto userDto);
    Cookie signIn(LoginForm loginForm);
//    void requestMessage(RequestForm requestForm);
}
