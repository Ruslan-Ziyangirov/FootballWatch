package ru.kpfu.itis.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.entities.Match;
import ru.kpfu.itis.entities.User;
import ru.kpfu.itis.services.MatchService;

@Controller
public class ChatPageController {

    private final Logger log = LoggerFactory.getLogger(ChatPageController.class);

    @Autowired
    private MatchService matchService;

    @GetMapping( "/chatPage/{id}")
    public ModelAndView getUserById(@PathVariable Long id,Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();
        Match match = matchService.getMatchById(id);
        modelAndView.addObject("match", match);
        User user = (User) authentication.getPrincipal();
        log.info("Перешел в комнату матча: "+match);
        modelAndView.addObject("id", user.getFirst_name());
        modelAndView.setViewName("chatPage");
        return modelAndView;
    }
}