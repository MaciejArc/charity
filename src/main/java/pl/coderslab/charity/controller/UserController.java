package pl.coderslab.charity.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.Service.UserService;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.UserRepository;

import javax.validation.Valid;



@Controller
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;


    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(Model model) {

        model.addAttribute("user", new User());

        return ("register");
    }

    @PostMapping("/register")
    public String registerPost(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }
        if (userRepository.findUserByEmail(user.getEmail()).isPresent()) {

            model.addAttribute("error", "Użytkownik o podanym adresie email istnieje!");
            return "register";
        }

        userService.registryNewAccount(user);

        return "index";
    }

    @GetMapping("/login")
    public String login(Model model, @RequestParam(required = false) String error){
if(error != null){
    model.addAttribute("error","Błedne dane logowania.");
}
        return ("login");
    }
}
