package seabattle.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipService {
    private final ShipRepository shipRepository;

    @Autowired
    public ShipService(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }

    public List<Ship> getAllShips() {
        return shipRepository.findAll();
    }

    public Ship getShipById(Long id) {
        return shipRepository.findById(id).orElse(null);
    }

    public Ship saveShip(Ship ship) {
        return shipRepository.save(ship);
    }


}
