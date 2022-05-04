package ru.kpfu.itis.controllers;

import ru.kpfu.itis.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.services.UsersService;

@Controller
public class RegistrationController {

    @Autowired
    private UsersService usersService;


    @GetMapping(value = "/registration")
    public ModelAndView getRegistrationPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registr");
        System.out.println("Перешел на регистрацию");
        return modelAndView;
    }

    @PostMapping(value = "/registration")
    public String addUser(String login, String password, String email, String first_name, String second_name){
        UserDto userDto = UserDto.builder()
                    .firstName(first_name)
                        .secondName(second_name)
                            .login(login)
                                .email(email)
                                    .password(password)
                                        .build();
        usersService.addUser(userDto);
        return "redirect:/main";
    }
}
