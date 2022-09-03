package app.controllers;

import app.models.Officer;
import app.repositories.OfficerRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OfficeController {

    private final OfficerRepo officerRepo;

    public OfficeController(OfficerRepo officerRepo) {
        this.officerRepo = officerRepo;
    }

    @GetMapping("/login")
    public String HomePage() {
        return "registercomp";
    }


    @GetMapping("/register")
    public String SignUpForm(Model model) {
        model.addAttribute("user", new Officer());
        return "registration_in_progress";
    }

    @PostMapping("/registration_in_progress")
    public String RegistrationInprogress(Officer user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        officerRepo.save(user);
        return "registration_in_progress";
    }
}
