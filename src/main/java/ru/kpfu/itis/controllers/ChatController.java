package ru.kpfu.itis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChatController {
    @GetMapping(value = "/chatP")
    public ModelAndView getProfilePage() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("chatP");
        System.out.println("Перешел в чат");
        return modelAndView;
    }
}
