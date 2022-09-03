package app.controllers;

import app.models.SpaceShip;
import app.models.SpaceShipClass;
import app.repositories.SpaceShipRepo;
import app.services.SpaceShipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class SpaceShipController {

    private final SpaceShipRepo spaceShipRepo;

    private final SpaceShipService spaceShipService;

    public SpaceShipController(SpaceShipRepo spaceShipRepo, SpaceShipService spaceShipService) {
        this.spaceShipRepo = spaceShipRepo;
        this.spaceShipService = spaceShipService;
    }

    @GetMapping(value = {"/SpaceShips"})
    public String spacesSHipData(Model model){

        List<SpaceShip> spaceShipList = spaceShipRepo.findAll();
        model.addAttribute("spaceShipList",spaceShipList);
        return "/SpaceShips";
    }

    @GetMapping(value = {"/spaceship"})
    public String saveNewSpaceShip(Model model) {
        model.addAttribute("newShip", new SpaceShip());
        model.addAttribute("shipClasses", SpaceShipClass.values());

        return "spaceship_new";
    }

    @GetMapping(value = {"/SpaceActive"})
    public String ActiveShip(Model model){
        List<SpaceShip> ships = spaceShipService.getActiveShip();
        model.addAttribute("shipActie",ships);
        return "/ActiveShip";
    }
}
