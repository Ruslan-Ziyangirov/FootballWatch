package ru.kpfu.itis.controllers;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.dto.LoginDto;
import ru.kpfu.itis.dto.UserDto;
import ru.kpfu.itis.entities.User;
import ru.kpfu.itis.exceptions.ApplicationException;
import ru.kpfu.itis.services.UsersService;

import javax.servlet.http.HttpServletResponse;

@Controller
public class RegistrationController {

    @Autowired
    private UsersService usersService;

    private static final String MY_EMAIL = "ziyangirovr@mail.ru";
    private static final String MY_PASSWORD = "Wpg0L4rAeMEJcNfzsPRH";
    private final Logger log = LoggerFactory.getLogger(RegistrationController.class);


    @GetMapping(value = "/registration")
    public ModelAndView getRegistrationPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registr");
        log.info("Перешел на регистрацию");
        return modelAndView;
    }

    @PostMapping(value = "/registration")
    public ModelAndView addUser(UserDto userDto, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(userDto.toString());
        String login = userDto.getLogin();
        String password = userDto.getPassword();
        String repassword = userDto.getRepassword();
        String status;
        if (login.length() < 3) {
            status = "Длина логина - не менее 2 символов!";
            modelAndView.addObject("validation", status);
            modelAndView.setViewName("registr");
            log.error("Неправильно ввели данные");
            return modelAndView;
        }
        if (password.length() < 5) {
            status = "Длина пароля - не менее 5 символов!";
            modelAndView.addObject("validation", status);
            modelAndView.setViewName("registr");
            log.error("Неправильно ввели данные");
            return modelAndView;
        }
        if (password.equals(repassword)) {
            User user = null;
            try {
                user = usersService.addUser(userDto);
            }catch (ApplicationException e){
                log.info("Пользователь с таким именем уже существует");
            }
            if (user != null) {
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
                    emailMessage.setSubject("Подтверждение регистрации");
                    // Текст сообщения.
                    emailMessage.setMsg(userDto.getFirst_name()+" "+userDto.getSecond_name()+
                            "вы успешно зарегистрировались на сайте \'Football Watch\'");
                    // Получатель
                    emailMessage.addTo(userDto.getEmail());
                    emailMessage.send();
                    log.info("Сообщение было отправлено!!");
                    modelAndView.setViewName("redirect:/profile");
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("Сообщение не отправилось(((");
                    modelAndView.setViewName("registr");
                }
                return modelAndView;
            } else {
                status = "Не удалось создать аккаунт!";
            }
        } else {
            status = "Пароли не совпадают!";
        }
        modelAndView.addObject("validation", status);
        return modelAndView;
    }
}
