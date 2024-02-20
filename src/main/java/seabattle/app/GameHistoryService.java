package seabattle.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameHistoryService {
    private final GameHistoryRepository gameHistoryRepository;

    @Autowired
    public GameHistoryService(GameHistoryRepository gameHistoryRepository) {
        this.gameHistoryRepository = gameHistoryRepository;
    }

    public List<GameHistory> getAllGameHistory() {
        return gameHistoryRepository.findAll();
    }

    public GameHistory getGameHistoryById(Long id) {
        return gameHistoryRepository.findById(id).orElse(null);
    }

    public GameHistory saveGameHistory(GameHistory gameHistory) {
        return gameHistoryRepository.save(gameHistory);
    }


}

