package ru.kpfu.itis.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.dto.LoginDto;
import ru.kpfu.itis.dto.RequestForMatchesDto;
import ru.kpfu.itis.models.User;
import ru.kpfu.itis.repositories.UserRepository;
import ru.kpfu.itis.services.UsersService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private UserRepository userRepository;

    private static final String MY_EMAIL = "ziyangirovr@mail.ru";
    private static final String MY_PASSWORD = "Wpg0L4rAeMEJcNfzsPRH";

    @PostMapping(value = "/main")
    public ModelAndView authorization(LoginDto loginDto, HttpServletResponse response){
        LoginDto auth = LoginDto.builder()
                .login(loginDto.getLogin())
                .password(loginDto.getPassword())
                .build();
        Cookie cookie = usersService.signIn(auth);

        ModelAndView modelAndView = new ModelAndView();
        if(cookie != null){
            response.addCookie(cookie);
            response.addCookie(new Cookie("login", loginDto.getLogin()));
            User user = null;
            Optional<User> optional = userRepository.findByLogin(loginDto.getLogin());
            if(optional.isPresent()){
                user = optional.get();
            }
            System.out.println(user);
            modelAndView.addObject("user", user);
            modelAndView.setViewName("profile");
            return modelAndView;
        }else {
            modelAndView.addObject("signInStatus", "Неправильный логин или пароль");
            modelAndView.setViewName("redirect:/registration");
            return modelAndView;
        }
    }

    @GetMapping(value = "/main")
    public ModelAndView getMainPage() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        System.out.println("Перешел на главную");
        return modelAndView;
    }

    @PostMapping(value = "/request", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView sendRequestMail(@RequestBody() RequestForMatchesDto requestMatches) throws Exception {

        String json = new ObjectMapper().writeValueAsString(requestMatches);
        System.out.println(json);


        ModelAndView modelAndView = new ModelAndView();

        try {
            Email emailMessage = new SimpleEmail();

            // Configuration
            emailMessage.setSmtpPort(25);
            emailMessage.setAuthenticator(new DefaultAuthenticator(MY_EMAIL, MY_PASSWORD));
            emailMessage.setHostName("smtp.mail.ru");
            emailMessage.setSSLOnConnect(true);


            // Отправитель
            emailMessage.setFrom(MY_EMAIL);

            // Тема сообщения
            emailMessage.setSubject("Расписание футбольных матчей");

            // Текст сообщения.
            emailMessage.setMsg(requestMatches.getFirstName()+" "+requestMatches.getSecondName()+
                    " вы заполняли форму на сайте" +
                    " FootballWatch - вот ваше расписание:\n" +
                    usersService.getAllMatches());

            // Получатель
            emailMessage.addTo(requestMatches.getEmail());
            emailMessage.send();
            modelAndView.setViewName("index");
            System.out.println("Сообщение было отправлено!!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Сообщение не отправилось(((");
            modelAndView.setViewName("profile");
        }
        return modelAndView;
    }
}
