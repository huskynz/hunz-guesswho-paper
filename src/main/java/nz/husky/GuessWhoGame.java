package nz.husky;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class GuessWhoGame {
    private Player targetPlayer;
    private List<Player> participants;
    private boolean gameActive;

    public GuessWhoGame() {
        this.participants = new ArrayList<>();
        this.gameActive = false;
    }

    public void startGame(Player target, List<Player> players) {
        this.targetPlayer = target;
        this.participants = players;
        this.gameActive = true;
        // Notify players that the game has started
    }

    public void stopGame() {
        this.targetPlayer = null;
        this.participants.clear();
        this.gameActive = false;
        // Notify players that the game has ended
    }

    public boolean isGameActive() {
        return gameActive;
    }

    public boolean guess(Player player, String guessedName) {
        if (targetPlayer.getName().equalsIgnoreCase(guessedName)) {
            stopGame();
            return true;
        } else {
            return false;
        }
    }

    public Player getTargetPlayer() {
        return targetPlayer;
    }
}
