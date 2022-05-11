package ru.kpfu.itis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
public class ChatPageController {

    @GetMapping("/chatPage")
    public ModelAndView getChatPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("id", UUID.randomUUID().toString());
        modelAndView.setViewName("chatPage");
        return modelAndView;
    }
}