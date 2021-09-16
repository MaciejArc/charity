package pl.coderslab.charity.controller;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.Service.UserServic;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.UserRepository;

import javax.validation.Valid;



@Controller
public class UserController {

    private final UserRepository userRepository;
    private final UserServic userServic;


    public UserController(UserRepository userRepository, UserServic userServic) {
        this.userRepository = userRepository;
        this.userServic = userServic;
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

        userServic.registryNewAccount(user);


        return "index";
    }
}
