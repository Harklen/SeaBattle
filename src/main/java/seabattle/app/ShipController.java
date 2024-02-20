package seabattle.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ships")
public class ShipController {
    private final ShipService shipService;

    @Autowired
    public ShipController(ShipService shipService) {
        this.shipService = shipService;
    }

    @GetMapping
    public List<Ship> getAllShips() {
        return shipService.getAllShips();
    }

    @GetMapping("/{id}")
    public Ship getShipById(@PathVariable Long id) {
        return shipService.getShipById(id);
    }

    @PostMapping
    public Ship createShip(@RequestBody Ship ship) {
        return shipService.saveShip(ship);
    }


}
