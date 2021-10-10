package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.Service.InstitutionService;
import pl.coderslab.charity.entity.Institution;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final InstitutionService institutionService;

    public AdminController(InstitutionService institutionService) {
        this.institutionService = institutionService;
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

    @GetMapping("/addInstitution")
    public String addInstitution(Model model, HttpServletRequest request) {
        if(!request.getParameter("id").isEmpty()){
            model.addAttribute("institution", institutionService.findInstitutionById(Long.parseLong(request.getParameter("id"))));
            return "admin/addInstitutions";
        }else {
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
    public String deleteInstitution(HttpServletRequest request){
        Institution institution = institutionService.findInstitutionById(Long.parseLong(request.getParameter("id")));
        institutionService.deteteInstitution(institution);
        return "redirect:/admin/institution";

    }


}

