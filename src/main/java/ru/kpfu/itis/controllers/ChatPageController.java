package ru.kpfu.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.models.Match;
import ru.kpfu.itis.models.User;
import ru.kpfu.itis.services.MatchService;

import java.util.List;
import java.util.UUID;

@Controller
public class ChatPageController {

    @Autowired
    private MatchService matchService;

    @GetMapping( "/chatPage/{id}")
    public ModelAndView getUserById(@PathVariable Long id,Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();
        Match match = matchService.getMatchById(id);
        modelAndView.addObject("match", match);
        User user = (User) authentication.getPrincipal();
        modelAndView.addObject("id", user.getFirst_name());
        modelAndView.setViewName("chatPage");
        return modelAndView;
    }
}