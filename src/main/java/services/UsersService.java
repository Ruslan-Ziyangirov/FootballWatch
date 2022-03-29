package services;

import form.LoginForm;
import form.RequestForm;
import form.UserForm;
import models.Request;
import models.User;

import javax.servlet.http.Cookie;

public interface UsersService {
    User register(UserForm userForm);
    Cookie signIn(LoginForm loginForm);
//    void requestMessage(RequestForm requestForm);
}
