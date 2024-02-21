package seabattle.app;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private List<Ship> ships;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private List<GameHistory> gameHistory;

    private boolean playerTurn;

    // Геттери та сеттери
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> ships) {
        this.ships.clear();
        this.ships.addAll(ships);
    }

    public List<GameHistory> getGameHistory() {
        return gameHistory;
    }

    public void setGameHistory(List<GameHistory> gameHistory) {
        this.gameHistory.clear();
        this.gameHistory.addAll(gameHistory);
    }

    public boolean isPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(boolean playerTurn) {
        if (this.playerTurn != playerTurn) {
            this.playerTurn = playerTurn;
        }
    }
}
