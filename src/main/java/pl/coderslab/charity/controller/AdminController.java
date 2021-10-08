package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.Service.InstitutionService;
import pl.coderslab.charity.entity.Institution;

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
    public String addInstitution(Model model) {
        model.addAttribute("institution", new Institution());
        return "admin/addInstitutions";
    }
}

