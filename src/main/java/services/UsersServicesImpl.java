package services;

import form.LoginForm;
import form.UserForm;
import models.Authorization;
import models.User;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.UserRepository;
import javax.servlet.http.Cookie;

@Service("userService")
public class UsersServicesImpl implements UsersService {

    @Autowired
    private UserRepository userRepository;

    public UsersServicesImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    public UsersServicesImpl(UserRepository userRepository, AuthRepository authRepository) {
//        this.userRepository = userRepository;
//        this.authRepository = authRepository;
//    }



    @Override
    public User register(UserForm userForm) {
//        usersRepository.save()
//        System.out.println(userForm);
//        User user = new User();
//        user.setFirst_name(userForm.getFirst_name());
//        user.setSecond_name(userForm.getSecond_name());
//        user.setEmail(userForm.getEmail());
//        user.setLogin(userForm.getLogin());
//
//        String passwordHash = new BCrypt().hashpw(userForm.getPassword(),BCrypt.gensalt(4));
//
//        user.setPasswordHash(passwordHash);
//
//        System.out.println("Помогите, пожалуйста");

        return null;

    }

    @Override
    public Cookie signIn(LoginForm loginForm) {
//
//        User user = userRepository.findByLogin(loginForm.getLogin());
//        System.out.println("Я в UsersServicesImpl в методе sign in");
//        System.out.println(user);
//        if(user != null){
//
//            if(BCrypt.checkpw(loginForm.getPassword(),user.getPasswordHash())){
//                System.out.println("Вход выполнен");
//
//                String cookieValue = UUID.randomUUID().toString();
//                System.out.println(cookieValue);
//
//                Authorization authorization = new Authorization();
//                authorization.setUser(user);
//                authorization.setCookieValue(cookieValue);
//                System.out.println(authorization);
//                authRepository.save(authorization);
//
//                Cookie cookie = new Cookie("Authorization",cookieValue);
//                cookie.setMaxAge(10*60*60);
//
//                return cookie;
//            }else{
//                System.out.println("Вход не выполнен");
//            }
//        }
        return null;
    }

//    @Override
//    public void requestMessage(RequestForm requestForm) {
//        System.out.println("Я ТУТ!!!!!!!!!!!!");
//        Request request = new Request();
//        request.setFirstName(requestForm.getFirstName());
//        request.setSecondName(requestForm.getSecondName());
//        request.setEmailRequest(requestForm.getEmail());
//
//
//        try {
//            Email email = new SimpleEmail();
//
//            // Configuration
//            email.setHostName("pop.mail.ru");
//            email.setSmtpPort(465);
//            email.setAuthenticator(new DefaultAuthenticator(MY_EMAIL, MY_PASSWORD));
//
//            // Отправитель
//            email.setFrom(MY_EMAIL);
//
//            // Тема сообщения
//            email.setSubject("Расписание футбольных матчей");
//
//            // Текст сообщения.
//            email.setMsg(requestForm.getFirstName()+" "+requestForm.getSecondName()+"вы заполняли форму на сайте" +
//                    "FootballWatch - вот ваше расписание");
//
//            // Получатель
//            email.addTo(requestForm.getEmail());
//            email.send();
//            System.out.println("Сообщение было отправлено!!");
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Сообщение не отправилось(((");
//        }
//
//    }
}
