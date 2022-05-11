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

    @Override
    public Cookie signIn(LoginDto loginDto) {
        User user = null;
        Optional<User> optional = userRepository.findByLogin(loginDto.getLogin());

        if(optional.isPresent()){
            user = optional.get();
        }
        System.out.println("Я в UsersServicesImpl в методе sign in");
        System.out.println(user);
        if(user != null){

            if(BCrypt.checkpw(loginDto.getPassword(),user.getPasswordHash())){
                System.out.println("Вход выполнен");
                String cookieValue = UUID.randomUUID().toString();
                System.out.println(cookieValue);

                Authorization authorization = new Authorization();
                authorization.setUser(user);
                authorization.setCookieValue(cookieValue);
                System.out.println(authorization);
                authRepository.save(authorization);

                Cookie cookie = new Cookie("Authorization",cookieValue);
                cookie.setMaxAge(10*60*60);

                return cookie;
            }else{
                System.out.println("Вход не выполнен");
            }
        }
        return null;
    }

    @Override
    public List<Match> getAllMatches(){
        return (List<Match>) matchRepository.findAll();
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
