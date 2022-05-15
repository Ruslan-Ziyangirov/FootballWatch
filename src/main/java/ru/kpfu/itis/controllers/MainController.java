package ru.kpfu.itis.controllers;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.dto.RequestForMatchesDto;
import ru.kpfu.itis.repositories.UserRepository;
import ru.kpfu.itis.security.authectication.CookieAuthentication;
import ru.kpfu.itis.services.MatchService;
import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

@Controller
public class MainController {

    @Autowired
    private MatchService matchService;

    @Autowired
    private UserRepository userRepository;

    private static final String MY_EMAIL = "ziyangirovr@mail.ru";
    private static final String MY_PASSWORD = "Wpg0L4rAeMEJcNfzsPRH";
    private Logger logger = Logger.getLogger(MainController.class.getName());

    @PostMapping(value = "/main")
    public String getLoginForm(HttpServletRequest request, ModelMap model, CookieAuthentication authentication) {
        if (request.getParameter("error") != null) {
            model.addAttribute("error", "Неправильный логин или пароль");
            logger.info("Неправильный логин или пароль");
        }
        return "index";
    }

    @GetMapping(value = "/main")
    public ModelAndView getMainPage(@AuthenticationPrincipal UserDetails userDetails) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("matches", matchService.getAllMatches());
        modelAndView.addObject("isAuthenticated", userDetails != null);
        modelAndView.setViewName("index");
        logger.info("Main Page");
        return modelAndView;
    }

    @PostMapping(value = "/request", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView sendRequestMail(@RequestBody() RequestForMatchesDto requestMatches) throws Exception {
        String json = new ObjectMapper().writeValueAsString(requestMatches);
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
                    matchService.getAllMatches());
            // Получатель
            emailMessage.addTo(requestMatches.getEmail());
            emailMessage.send();
            modelAndView.setViewName("index");
            logger.info("Сообщение было отправлено!");
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Сообщение не отправилось(((");
            modelAndView.setViewName("profile");
        }
        return modelAndView;
    }
}
