package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.Service.InstitutionService;
import pl.coderslab.charity.Service.UserService;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final InstitutionService institutionService;
    private final UserService userService;

    public AdminController(InstitutionService institutionService, UserService userService) {
        this.institutionService = institutionService;
        this.userService = userService;
    }

    @GetMapping("/dashboard")
    public String admin() {
        return "admin/index";
    }

    @GetMapping("/institution")
    public String institution(Model model) {
        model.addAttribute("institutionList", institutionService.institutionList());

        return "admin/institution";
    }

    //Add and Edit institution
    @GetMapping("/addInstitution")
    public String addInstitution(Model model, HttpServletRequest request) {
        if (!request.getParameter("id").isEmpty()) {
            model.addAttribute("institution", institutionService.findInstitutionById(Long.parseLong(request.getParameter("id"))));
            return "admin/addInstitutions";
        } else {
            model.addAttribute("institution", new Institution());
            return "admin/addInstitutions";
        }

    }

    @PostMapping("/addInstitution")
    public String addInstitutionPost(@Valid Institution institution, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/addInstitutions";
        }
        institutionService.addNewInstitution(institution);
        return "redirect:/admin/institution";

    }

    @GetMapping("/deleteInstitution")
    public String deleteInstitution(HttpServletRequest request) {
        Institution institution = institutionService.findInstitutionById(Long.parseLong(request.getParameter("id")));
        institutionService.deteteInstitution(institution);
        return "redirect:/admin/institution";

    }

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("usersList", userService.userList());
        return "/admin/users";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(HttpServletRequest request) {
        User user = userService.findById(Long.parseLong(request.getParameter("id")));
        if(user.getRoles().equals("ROLE_USER")){
            userService.deleteUser(user);
            return "redirect:/admin/users";
        }else {
            userService.deleteUser(user);
            return "redirect:/admin/admins";
        }


    }
    @GetMapping("/editUser")
    public String editUser(HttpServletRequest request, Model model){
        User user = userService.findById(Long.parseLong(request.getParameter("id")));
        model.addAttribute("user",user);
        return "/admin/editUser";

    }
    @PostMapping("/editUser")
    public String editUserPost(@Valid User user, BindingResult result, Model model){
        User userOld = userService.findById(user.getId());
        if(result.hasErrors()){
            return "/admin/editUser";
        }else {
            if (userOld.getRoles().equals("ROLE_USER")){
                userService.editUser(user);
                return "redirect:/admin/users";
            }else {
                userService.editAdmin(user);
                return "redirect:/admin/admins";
            }

        }

    }

    @GetMapping("/addUser")
    public String addUser(Model model) {

        model.addAttribute("user", new User());

        return ("/admin/addUsers");
    }

    @PostMapping("/addUser")
    public String addUserPost(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/admin/addUsers";
        }
        if (userService.findByEmailOpt(user.getEmail()).isPresent()) {

            model.addAttribute("error", "Użytkownik o podanym adresie email istnieje!");
            return "/admin/addUsers";
        }

        userService.registryNewAccount(user);

        return "redirect:/admin/users";
    }

    @GetMapping("/lockUser")
    public String lockUser(@RequestParam(value = "id") String id){
        userService.lockUser(id);
        return "redirect:/admin/users";
    }

    @GetMapping("/admins")
    public String admins(Model model){
        model.addAttribute("adminsList",userService.adminList());
        return "/admin/admins";

    }

    @GetMapping("/addAdmin")
    public String addAdmin(Model model){
        model.addAttribute("user",new User());
        return "/admin/addAdmin";
    }
    @PostMapping("/addAdmin")
    public String addAdminPost(@Valid User user,BindingResult result, Model model){
        if (result.hasErrors()){
            return "/admin/addAdmin";
        }
        if(userService.findByEmailOpt(user.getEmail()).isPresent()){
            model.addAttribute("error", "Użytkownik o podanym adresie email istnieje!");
            return "/admin/addAdmin";
        }
      userService.registryNewAdmin(user);


        return "redirect:/admin/admins";
    }


}

