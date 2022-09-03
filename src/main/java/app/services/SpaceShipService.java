package app.services;


import app.models.SpaceShip;
import app.repositories.SpaceShipRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpaceShipService {

    private final SpaceShipRepo spaceShipRepo;

    public SpaceShipService(SpaceShipRepo spaceShipRepo) {
        this.spaceShipRepo = spaceShipRepo;
    }

    public List<SpaceShip> getAll(){
        return (List<SpaceShip>) spaceShipRepo.findAll();
    }

    public List<SpaceShip> getActiveShip(){
        List<SpaceShip> result = new ArrayList<>();
        for (SpaceShip ship : getAll()){
            if (ship.isActive()){
                result.add(ship);
            }
        }
        return result;
    }

}
