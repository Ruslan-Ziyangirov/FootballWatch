package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import services.UsersService;

@Controller
public class RegistrationController {


    @GetMapping(value = "/registration")
    public ModelAndView getRegistrationPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registr");
        System.out.println("Перешел на регистрацию");
        return modelAndView;
    }
}
