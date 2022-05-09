package com.prakhar.shopping.finalShopping.controller;

import com.prakhar.shopping.finalShopping.model.User;
import com.prakhar.shopping.finalShopping.repository.UserRepo;
import com.prakhar.shopping.finalShopping.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@EnableAutoConfiguration
@Controller
public class UserController {

    @Autowired
    private SecurityService securityService;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    User user;



    @Autowired
    private PasswordEncoder encoder;

    @GetMapping("/")
    public String showLoginPage(){
        return "login";

    }
    @PostMapping("/login")
    public String login(String email, String password){

        boolean loginresponse = securityService.login(email, password);
        if (loginresponse){
            return "redirect:index";
        }
        return "login";
    }
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/showReg")
    public String showRegistrationPage(Model model){
        model.addAttribute("user", new User());
        return "registrationUser";
    }

    @PostMapping("/registration")
    public  String register(@Valid User user, BindingResult result){

        if(result.hasErrors()){
            return "registrationUser";
        }

        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);
        return "login";
    }

}
