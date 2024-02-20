package seabattle.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gameHistory")
public class GameHistoryController {
    private final GameHistoryService gameHistoryService;

    @Autowired
    public GameHistoryController(GameHistoryService gameHistoryService) {
        this.gameHistoryService = gameHistoryService;
    }

    @GetMapping
    public List<GameHistory> getAllGameHistory() {
        return gameHistoryService.getAllGameHistory();
    }

    @GetMapping("/{id}")
    public GameHistory getGameHistoryById(@PathVariable Long id) {
        return gameHistoryService.getGameHistoryById(id);
    }

    @PostMapping
    public GameHistory createGameHistory(@RequestBody GameHistory gameHistory) {
        return gameHistoryService.saveGameHistory(gameHistory);
    }

}

