package ru.kpfu.itis.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.repositories.MatchRepository;
import ru.kpfu.itis.repositories.UserRepository;
import ru.kpfu.itis.services.MatchService;
import ru.kpfu.itis.services.MatchServiceImpl;

@Controller
public class ChatController {

    private final Logger log = LoggerFactory.getLogger(ChatController.class);

    @Autowired
    private MatchService matchService;

    @GetMapping(value = "/chatP")
    public ModelAndView getProfilePage() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("matches", matchService.getAllMatches());
        modelAndView.setViewName("chatP");
        log.info("Перешел на страницу с чатами");
        return modelAndView;
    }
}
