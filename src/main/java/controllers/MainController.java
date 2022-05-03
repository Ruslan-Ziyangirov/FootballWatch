package controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import services.UsersService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MainController {

    @GetMapping(value = "/main")
    public ModelAndView getMainPage() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        System.out.println("Перешел на главную");
        return modelAndView;
    }
}
