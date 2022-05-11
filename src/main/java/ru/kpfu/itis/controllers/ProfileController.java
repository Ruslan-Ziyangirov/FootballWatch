package ru.kpfu.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.Authentication;
import ru.kpfu.itis.dto.LoginDto;
import ru.kpfu.itis.models.User;
import ru.kpfu.itis.repositories.UserRepository;

import java.util.Optional;

@Controller
public class ProfileController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/profile")
    public ModelAndView getProfilePage(LoginDto loginDto) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("profile");
        return modelAndView;
    }

}
