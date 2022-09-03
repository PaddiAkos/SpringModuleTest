package app.controllers;

import app.models.Crew;
import app.repositories.CrewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CrewController {

    @Autowired
    private CrewRepo crewRepo;


    public CrewController(CrewRepo crewRepo){
        this.crewRepo=crewRepo;
    }

    @GetMapping(value = {"/crewlist"})
    String allC(Model model){

        List<Crew> crews = (List<Crew>) crewRepo.findAll();
        model.addAttribute("crewList",crews);
        return "Crew";

    }



}
