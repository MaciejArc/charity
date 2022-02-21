package pl.coderslab.charity.controller;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.Service.UserService;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
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
    public String login(Model model, @RequestParam(required = false) String error) {
        if (error != null) {
            model.addAttribute("error", "Błedne dane logowania.");
        }

        return ("login");
    }

    @GetMapping("/user/index")
    public String index(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("userName", user.getFullName());
        return ("/user/index");
    }

    @GetMapping("/user/dashboard")
    public String dashboard(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("userName", user.getFullName());

        return ("/user/dashboard");

    }

    @GetMapping("/user/editUser")
    public String editUser(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("userName", user.getFullName());

        model.addAttribute("user", user);
        return ("/user/editUser");
    }

    @PostMapping("/user/editUser")
    public String editUserPost(@Valid User user, BindingResult result, Model model) {
        User user1 = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("userName", user1.getFullName());

        if (result.hasErrors()) {
            return "/user/editUser";
        }
        if (userRepository.findUserByEmail(user.getEmail()).isPresent()) {

            if (!user1.getEmail().equals(user.getEmail())) {
                model.addAttribute("error", "Użytkownik o podanym adresie email istnieje!");
                return "/user/editUser";
            }

        }

        userService.editUserWithoutId(user1,user);

        return "user/index";
    }

    @GetMapping("/user/editPassword")
    public String editPassword(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("userName", user.getFullName());

        return "user/editPassword";
    }
    @PostMapping("/user/editPassword")
    public String editPasswordPost(Model model,HttpServletRequest request){
        User user1 = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("userName", user1.getFullName());
        if (request.getParameter("password").length()<5) {
            model.addAttribute("error","Hasło musi zawierac conajmniej 5 znaków");
            return "/user/editPassword";
        }
        userService.editPassword(user1,request.getParameter("password"));
        return "user/dashboard";

    }

}
